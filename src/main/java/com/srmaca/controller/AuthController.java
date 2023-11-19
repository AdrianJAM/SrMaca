package com.srmaca.controller;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srmaca.dto.DtoAuthResponse;
import com.srmaca.dto.DtoLogin;
import com.srmaca.dto.DtoRegister;
import com.srmaca.model.admin.Roles;
import com.srmaca.model.users.Users;
import com.srmaca.repository.RoleRepository;
import com.srmaca.repository.UserRepository;
import com.srmaca.security.JwtTokenProvider;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    
    public AuthController(
        AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, RoleRepository roleRepository, UserRepository userRepository, JwtTokenProvider jwtTokenProvider
    ){
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping(value = "register")
    public ResponseEntity<String> register(@RequestBody DtoRegister dtoRegister){
        if (userRepository.existsByUsername(dtoRegister.getUsername())){
            return new ResponseEntity<>("El usuario ya existe, intenta otro", HttpStatus.BAD_REQUEST);
        }
        Users users = new Users();
        users.setUsername(dtoRegister.getUsername());
        users.setPassword(passwordEncoder.encode(dtoRegister.getPassword()));
        Roles roles = roleRepository.findByName("USER").get();
        users.setRoles(Collections.singletonList(roles));
        userRepository.save(users);
        return new ResponseEntity<>("Usuario creado con exito", HttpStatus.OK);
    }

    @PostMapping(value = "registerAdm")
    public ResponseEntity<String> registerAdmin(@RequestBody DtoRegister dtoRegister){
        if (userRepository.existsByUsername(dtoRegister.getUsername())){
            return new ResponseEntity<>("El usuario ya existe, intenta otro", HttpStatus.BAD_REQUEST);
        }
        Users users = new Users();
        users.setUsername(dtoRegister.getUsername());
        users.setPassword(passwordEncoder.encode(dtoRegister.getPassword()));
        Roles roles = roleRepository.findByName("ADMIN").get();
        users.setRoles(Collections.singletonList(roles));
        userRepository.save(users);
        return new ResponseEntity<>("Admin creado con exito", HttpStatus.OK);
    }

    @PostMapping(value = "login")
    public ResponseEntity<DtoAuthResponse> login(@RequestBody DtoLogin dtoLogin){
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(dtoLogin.getUsername(), dtoLogin.getPassword()));
        String token = jwtTokenProvider.generateToken(authentication);
        return new ResponseEntity<>(new DtoAuthResponse(token), HttpStatus.OK);
    }
}
