package com.faidihr.mobile.app.api.service.impl;


import com.faidihr.mobile.app.api.service.RestTemplateService;
import com.faidihr.mobile.app.api.util.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {
    @Override
    public ResponseEntity<String> getRequest(String url, Map<String, String> httpHeaderParams) {
        final HttpHeaders headers = this.appendHttpHeaders(httpHeaderParams);

        final RestTemplate restTemplate = createRestTemplate();

        final HttpEntity<String> request = new HttpEntity<>(headers);

        return restTemplate.exchange(url, HttpMethod.GET, request, String.class);

    }

    @Override
    public ResponseEntity<String> postRequest(String url, Object postObject, Map<String, String> httpHeaderParams) throws JsonProcessingException {
       System.out.println("url >> "+url);
        final HttpHeaders headers = this.appendHttpHeaders(httpHeaderParams);

        final RestTemplate restTemplate = createRestTemplate();
        final ObjectMapper mapper = new ObjectMapper();
        String postObjectString = null;

        if(postObject instanceof JSONObject) {
            postObjectString = ((JSONObject)postObject).toString();
        } else {
            postObjectString = postObject instanceof String ? String.valueOf(postObject) : mapper.writeValueAsString(postObject);
        }

        final HttpEntity<String> request = new HttpEntity<>(postObjectString, headers);
        return restTemplate.exchange(url, HttpMethod.POST, request, String.class);
    }

    @Override
    public ResponseEntity<String> putRequest(String url, Object putObject, Map<String, String> httpHeaderParams) throws JsonProcessingException {
        final HttpHeaders headers = this.appendHttpHeaders(httpHeaderParams);

        final RestTemplate restTemplate = createRestTemplate();
        final ObjectMapper mapper = new ObjectMapper();
        String putObjectString = null;

        if(putObject instanceof JSONObject) {
            putObjectString = ((JSONObject)putObject).toString();
        } else {
            putObjectString = putObject instanceof String ? String.valueOf(putObject) : mapper.writeValueAsString(putObject);
        }

        final HttpEntity<String> request = new HttpEntity<>(putObjectString, headers);
        return restTemplate.exchange(url, HttpMethod.PUT, request, String.class);
    }

    @Override
    public ResponseEntity<String> patchRequest(String url, Object patchObject, Map<String, String> httpHeaderParams) throws JsonProcessingException {
        final HttpHeaders headers = this.appendHttpHeaders(httpHeaderParams);

        final RestTemplate restTemplate = createRestTemplate();
        final ObjectMapper mapper = new ObjectMapper();
        String patchObjectString = null;

        if(patchObject instanceof JSONObject) {
            patchObjectString = ((JSONObject)patchObject).toString();
        } else {
            patchObjectString = patchObject instanceof String ? String.valueOf(patchObject) : mapper.writeValueAsString(patchObject);
        }

        final HttpEntity<String> request = new HttpEntity<>(patchObjectString, headers);
        return restTemplate.exchange(url, HttpMethod.PATCH, request, String.class);
    }

    @Override
    public ResponseEntity<String> deleteRequest(String url, Object deleteObject, Map<String, String> httpHeaderParams) throws JsonProcessingException {
        final HttpHeaders headers = this.appendHttpHeaders(httpHeaderParams);

        final RestTemplate restTemplate = createRestTemplate();
        final ObjectMapper mapper = new ObjectMapper();
        String deleteObjectString = null;

        if(deleteObject instanceof JSONObject) {
            deleteObjectString = ((JSONObject)deleteObject).toString();
        } else {
            deleteObjectString = deleteObject instanceof String ? String.valueOf(deleteObject) : mapper.writeValueAsString(deleteObject);
        }

        final HttpEntity<String> request = new HttpEntity<>(deleteObjectString, headers);
        return restTemplate.exchange(url, HttpMethod.DELETE, request, String.class);
    }

    private RestTemplate createRestTemplate() {
        final SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setOutputStreaming(false);

        return new RestTemplate(requestFactory);
    }

    private HttpHeaders appendHttpHeaders(Map<String, String> httpHeaderParams) {
        final HttpHeaders headers = new HttpHeaders();

        String mediaType = !Objects.isNull(httpHeaderParams) && httpHeaderParams.containsKey(Constants.MEDIATYPE) ? httpHeaderParams.get(Constants.MEDIATYPE) : "";

        switch(mediaType) {
            case "json":
                headers.setContentType(MediaType.APPLICATION_JSON);
                break;
            case "xml":
                headers.setContentType(MediaType.APPLICATION_XML);
                break;
            default:
                headers.setContentType(MediaType.APPLICATION_JSON);
                break;
        }

        String basicAuthUsername = !Objects.isNull(httpHeaderParams) && httpHeaderParams.containsKey(Constants.BASICAUTHUSERNAME) ?
                httpHeaderParams.get(Constants.BASICAUTHUSERNAME) : null;
        String basicAuthPassword = !Objects.isNull(httpHeaderParams) && httpHeaderParams.containsKey(Constants.BASICAUTHPASSWORD) ?
                httpHeaderParams.get(Constants.BASICAUTHPASSWORD) : null;

        if(!Objects.isNull(basicAuthUsername) && !Objects.isNull(basicAuthPassword))
            headers.setBasicAuth(basicAuthUsername, basicAuthPassword);

        if(!Objects.isNull(httpHeaderParams))
            httpHeaderParams.entrySet().stream()
                    .filter(e -> !e.getKey().equals(Constants.MEDIATYPE) && !e.getKey().equals(Constants.BASICAUTHUSERNAME) &&
                            !e.getKey().equals(Constants.BASICAUTHPASSWORD))
                    .forEach(e -> headers.add(e.getKey(), e.getValue()));

        return headers;

    }
}
