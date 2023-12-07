package com.example.demo.Core.CustomResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler{
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status,Object responseObj){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("response",responseObj);
        map.put("message",message);

        return new ResponseEntity<Object>(map,status);
    }
}
