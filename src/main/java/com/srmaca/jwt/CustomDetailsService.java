package com.srmaca.jwt;

import java.util.ArrayList;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import com.srmaca.model.users.Users;
import com.srmaca.repository.UsersRepository;

@Slf4j
@Service
public class CustomDetailsService implements UserDetailsService{
    @Autowired
    private UsersRepository userRepository;

    private Users userDetail;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        log.info("Inside loadUserByUsername method of CustomDetailsService {}", username);
        userDetail = userRepository.findByEmail(username);

        if(!Objects.isNull(userDetail)){
            return new org.springframework.security.core.userdetails.User(userDetail.getEmail(), userDetail.getPassword(), new ArrayList<>());
        }
        else{
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }


    public Users getUserDetail(){
        return userDetail;
    }
}
