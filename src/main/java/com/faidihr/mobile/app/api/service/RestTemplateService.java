package com.faidihr.mobile.app.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface RestTemplateService {
    ResponseEntity<String> getRequest(String url, Map<String, String> httpHeaderParams);

    ResponseEntity<String> postRequest(String url, Object postObject, Map<String, String> httpHeaderParams) throws JsonProcessingException;

    ResponseEntity<String> putRequest(String url, Object putObject, Map<String, String> httpHeaderParams) throws JsonProcessingException;

    ResponseEntity<String> patchRequest(String url, Object patchObject, Map<String, String> httpHeaderParams) throws JsonProcessingException;

    ResponseEntity<String> deleteRequest(String url, Object deleteObject, Map<String, String> httpHeaderParams) throws JsonProcessingException;
}
