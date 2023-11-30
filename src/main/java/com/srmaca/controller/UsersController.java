package com.srmaca.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srmaca.model.ecommerce.data.ConstantData;
import com.srmaca.service.UsersService;
import com.srmaca.utils.DataUtils;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    
    @Autowired
    private UsersService usersService;

    @PostMapping(value = "signUp", headers = "Accept=application/json")
    public ResponseEntity<String> signUp(@RequestBody(required = true)Map<String, String> requestMap){
        try {
            return usersService.signUp(requestMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DataUtils.getResponseEntity(ConstantData.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(value = "login", headers = "Accept=application/json")
    public ResponseEntity<String> login(@RequestBody(required = true) Map<String, String> requestMap){
        try {
            return usersService.login(requestMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DataUtils.getResponseEntity(ConstantData.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
