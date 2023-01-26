package com.faidihr.mobile.app.api.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MultitenantJdbcTemplateApplication {

    @Autowired
    DataSourceMap dataSourceMap;

    @Bean
    public DataSource dataSource() throws Exception {
        MultiTenantDataSource customDataSource = new MultiTenantDataSource();
        customDataSource.setTargetDataSources(dataSourceMap.LoadDataSourcesHashMap());
        return customDataSource;
    }

}


