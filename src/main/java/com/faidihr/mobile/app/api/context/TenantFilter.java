package com.faidihr.mobile.app.api.context;


import org.json.JSONObject;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


@Component
@Order(1)
public class TenantFilter extends OncePerRequestFilter {
    JSONObject respObject = new JSONObject();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {


        String tenantID = request.getHeader("X-TenantID");

        if (!Objects.isNull(tenantID)) {
            System.out.println("tenantID>> " + tenantID);
            TenantContext.setCurrentTenant(tenantID);
        }
        chain.doFilter(request, response);

    }
}
