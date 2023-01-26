//package com.faidihr.mobile.app.api.security;
//
//
//import com.faidihr.mobile.app.api.context.TenantContext;
//import org.json.JSONObject;
//
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//@Component
//@Order(1)
//public class RequestFilter extends OncePerRequestFilter {
//
//    JSONObject respObject = new JSONObject();
//
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//            throws ServletException, IOException {
//
//        HttpServletResponseCopier responseCopier = new HttpServletResponseCopier(response);
//
//        responseCopier.flushBuffer();
//
//        if (request.getRequestURI().equals("/ebankdb/db-api/authorize")) {
//            String countryCode = request.getHeader("X-Country-Code");
//            if (!StringUtils.hasLength(countryCode)) {
//                respObject.put("resp_desc", "Country Code missing in the headers");
//                respObject.put("resp_code", response.SC_EXPECTATION_FAILED);
//
//                response.reset();
//                String json = respObject.toString();
//                response.getWriter().write(json);
//
//            } else {
//                // "ZM"; //get from token
//                chain.doFilter(request, responseCopier);
//            }
//            return;
//        }
//        String tenantID = request.getHeader("X-TenantID");
//        TenantContext.setCurrentTenant(tenantID);
//        chain.doFilter(request, responseCopier);
//
//    }
//
//}
