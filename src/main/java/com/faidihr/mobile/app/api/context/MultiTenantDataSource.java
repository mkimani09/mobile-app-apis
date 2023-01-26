package com.faidihr.mobile.app.api.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class MultiTenantDataSource extends AbstractRoutingDataSource {
    @Value("${spring.datasource.default_tenant}")
    private static String defaultTenant;
    @Override
    protected String determineCurrentLookupKey() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();     // get request object
        String tenantId = "0";
        try {
            String currentTenant = TenantContext.getCurrentTenant();

            if (currentTenant != null) {
                tenantId = currentTenant;
            } else if (attr != null && attr.getRequest().getHeader("X-TenantID") != null) {
                tenantId = attr.getRequest().getHeader("X-TenantID");
            }
        } catch (Exception ex) {
            logger.info("error code > " + ex.getClass().getSimpleName());
        }

        return tenantId;
    }
}
