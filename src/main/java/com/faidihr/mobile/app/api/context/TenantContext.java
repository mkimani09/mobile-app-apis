package com.faidihr.mobile.app.api.context;

public class TenantContext {

   // private static final ThreadLocal<String> CURRENT_TENANT = new ThreadLocal<>();
    private static final ThreadLocal<String> CURRENT_TENANT = new InheritableThreadLocal<>();

    public static String getCurrentTenant() {
        return CURRENT_TENANT.get();
    }

    public static void setCurrentTenant(String tenant) {
        CURRENT_TENANT.set(tenant);
    }
}