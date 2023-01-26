package com.faidihr.mobile.app.api.context;


import com.faidihr.mobile.app.api.service.RestTemplateService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;


/**
 * Created by JavaDeveloperZone on 22-01-2017.
 */
@Component
public class DataSourceMap {
    @Autowired
    RestTemplateService restTemplateService;


    public Map<Object, Object> LoadDataSourcesHashMap() throws Exception {

        Map hashMap = new HashMap();
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        String url = "jdbc:mysql://localhost:3306/" + "crewhrmsclients";

        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url(url);
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("");

        hashMap.put("0", dataSourceBuilder.build());

        final HttpHeaders headers = new HttpHeaders();

        final RestTemplate restTemplate = createRestTemplate();

        final HttpEntity<String> request = new HttpEntity<>(headers);

//        Object objClients = clientsServiceImp.getClients();
//        System.out.println("objClients >> "+objClients);
//System.exit(0);
        ResponseEntity<String> obj = restTemplate.exchange("http://localhost:8082/auth/api/clients", HttpMethod.GET, request, String.class);
        List<Object> list = Collections.singletonList(obj.getBody());


        for (Object clientsObj : list) {

            JSONArray arr = new JSONArray(clientsObj.toString());
            for (int n = 0; n < arr.length(); n++) {
                JSONObject object = arr.getJSONObject(n);
                String clientUrl = "jdbc:mysql://localhost:3306" + "/" + object.get("dbname");
                dataSourceBuilder.url(clientUrl);
                hashMap.put(object.get("clientId").toString(), dataSourceBuilder.build());
            }
        }
        System.out.println("hashMap >> "+ hashMap.toString());
        return hashMap;
    }

    private static RestTemplate createRestTemplate() {
        final SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setOutputStreaming(false);

        return new RestTemplate(requestFactory);
    }
}

