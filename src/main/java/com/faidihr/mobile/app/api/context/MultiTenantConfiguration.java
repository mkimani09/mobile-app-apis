//package com.faidihr.mobile.app.api.context;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.env.Environment;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.Objects;
//
//@EnableTransactionManagement
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//public class MultiTenantConfiguration {
//
//    @Autowired
//    Environment environment;
//
//    @Bean
//    public DataSource dataSource() {
//
//        /**
//         File[] files = Paths.get("allTenants").toFile().listFiles();
//         Map<Object, Object> resolvedDataSources = new HashMap<>();
//
//         for (File propertyFile : files) {
//         Properties tenantProperties = new Properties();
//         DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//
//         try {
//         tenantProperties.load(new FileInputStream(propertyFile));
//         String tenantId = tenantProperties.getProperty("name");
//
//         dataSourceBuilder.driverClassName(tenantProperties.getProperty("datasource.driver-class-name"));
//         dataSourceBuilder.username(tenantProperties.getProperty("datasource.username"));
//         dataSourceBuilder.password(tenantProperties.getProperty("datasource.password"));
//         dataSourceBuilder.url(tenantProperties.getProperty("datasource.url"));
//         resolvedDataSources.put(tenantId, dataSourceBuilder.build());
//         } catch (IOException exp) {
//         throw new RuntimeException("Problem in tenant datasource:" + exp);
//         }
//         }
//
//         AbstractRoutingDataSource dataSource = new MultiTenantDataSource();
//         dataSource.setDefaultTargetDataSource(resolvedDataSources.get("tenant_1"));
//         dataSource.setTargetDataSources(resolvedDataSources);
//
//         dataSource.afterPropertiesSet();
//         */
//        String tenant = Objects.isNull(TenantContext.getCurrentTenant())?"hrms":TenantContext.getCurrentTenant(); //remember to get from token
//
//       String url = environment.getProperty("spring.datasource.url") + "/" + tenant;
//        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName(environment.getProperty("spring.datasource.driver-class-name"));
//        dataSourceBuilder.url(url);
//        dataSourceBuilder.username(environment.getProperty("spring.datasource.username"));
//        //dataSourceBuilder.password("spring.datasource.password");
//        return dataSourceBuilder.build();
//    }
//
//}