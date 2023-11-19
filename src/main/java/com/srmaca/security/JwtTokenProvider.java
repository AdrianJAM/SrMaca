package com.srmaca.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {
    public String generateToken(Authentication authentication){
        String username = authentication.getName();
        Date time_actual = new Date();
        Date expirationToken = new Date(time_actual.getTime() + SecurityConstants.JWT_EXPIRATION_TOKEN);
        String token = Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(expirationToken)
                .signWith(Keys.hmacShaKeyFor(SecurityConstants.JWT_SIGN.getBytes()))
                .compact();
        return token;
    }

    public String getUsernameByJWT(String token){
        byte[] secretKeyBytes = SecurityConstants.JWT_SIGN.getBytes(StandardCharsets.UTF_8);
        SecretKey secretKey = Keys.hmacShaKeyFor(secretKeyBytes);
        Claims claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }
    

    public boolean validateToken(String token){
        byte[] secretKeyBytes = SecurityConstants.JWT_SIGN.getBytes(StandardCharsets.UTF_8);
        SecretKey secretKey = Keys.hmacShaKeyFor(secretKeyBytes);
        try{
            Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token);
            return true;
        }catch (Exception e){
            throw new AuthenticationCredentialsNotFoundException("JWT ha expirado o esta incorrecto");
        }
    }
}
