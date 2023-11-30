package com.srmaca.service.impl;

import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import com.srmaca.model.ecommerce.data.ConstantData;
import com.srmaca.model.users.Users;
import com.srmaca.repository.UsersRepository;
import com.srmaca.security.CustomDetailsService;
import com.srmaca.security.jwt.JwtUtil;
import com.srmaca.service.UsersService;
import com.srmaca.utils.DataUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomDetailsService customDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Registering user: {}", requestMap.get("username"));
        try{
            if (validateSignUpMap(requestMap)){
                Users user = usersRepository.findByEmail(requestMap.get("email"));
                if(Objects.isNull(user)){
                    usersRepository.save(getUserFromMap(requestMap));
                    return DataUtils.getResponseEntity("User registered successfully", HttpStatus.CREATED);
                }
                else {
                    return DataUtils.getResponseEntity("User already exists", HttpStatus.BAD_REQUEST);
                }
            } else {
                return DataUtils.getResponseEntity(ConstantData.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            e.printStackTrace();
            log.error("Error registering user: {}", e.getMessage());
        }
        return DataUtils.getResponseEntity(ConstantData.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean validateSignUpMap(Map<String, String> requestMap) {
        if ( requestMap.containsKey("username") && requestMap.containsKey("password")
                && requestMap.containsKey("email") && requestMap.containsKey("telephone")){
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

    @Override
    public ResponseEntity<String> login(Map<String, String> requestMap){
        log.info("Logging in user: {}", requestMap.get("username"));
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestMap.get("email"), requestMap.get("password")));
            if (authentication.isAuthenticated()) {
                if(customDetailsService.getUserDetail().getStatus().equalsIgnoreCase("true")){
                    return new ResponseEntity<String>(
                        "{\"token\":\"" + 
                        jwtUtil.generateToken(
                            customDetailsService.getUserDetail().getEmail(), 
                            customDetailsService.getUserDetail().getRole()) + "\"}", 
                            HttpStatus.OK);
                } else {
                            return new ResponseEntity<String>("{\"message\":\"WAIT APROVE ADMIN\"}", HttpStatus.BAD_REQUEST);

                }
            }
        } catch (Exception e) {
            log.error("Error logging in user: {}", e.getMessage());
        }
        return new ResponseEntity<String>("{\"message\":\"INVALID CREDENTIALS\"}", HttpStatus.BAD_REQUEST);
    }
}
