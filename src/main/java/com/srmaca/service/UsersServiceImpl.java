package com.srmaca.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.srmaca.model.users.Users;
import com.srmaca.repository.UsersRepository;
import com.srmaca.utils.DataUtils;


public class UsersServiceImpl implements UsersService{
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        return null;
    }

    private boolean validateSignUpMap(Map<String, String> requestMap) {
        if ( requestMap.containsKey("username") && requestMap.containsKey("password")
                && requestMap.containsKey("email") && requestMap.containsKey("telephone")
                && requestMap.containsKey("status") && requestMap.containsKey("role") ){
                return true;
                }
                return false;
    }

    private Users getUserFromMap(Map<String, String> requestMap) {
        Users user = new Users();
        user.setUsername(requestMap.get("username"));
        user.setPassword(requestMap.get("password"));
        user.setEmail(requestMap.get("email"));
        user.setTelephone(requestMap.get("telephone"));
        user.setStatus(requestMap.get("status"));
        user.setRole(requestMap.get("role"));
        return user;
    }
}
