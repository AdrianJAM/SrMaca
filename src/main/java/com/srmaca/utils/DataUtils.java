package com.srmaca.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DataUtils {

    private DataUtils() {
    }

    public static ResponseEntity<String> getResponseEntity(String message, int status) {
        return new ResponseEntity<String>("Mensaje : " + message,HttpStatus.valueOf(status));
    }
}
