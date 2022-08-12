package com.kwetulabs.numlookup.responses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status);
        map.put("statusCode", 200);

        if (ObjectUtils.isEmpty(responseObj)) map.put("data", Collections.emptyList()); else map.put("data", responseObj);

        return new ResponseEntity<Object>(map, status);

    }

    public static ResponseEntity<Object> generateErrorResponse(String message, HttpStatus status, Object responseObj){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status);
        map.put("error", responseObj);

        return new ResponseEntity<Object>(map, status);
    }
}
