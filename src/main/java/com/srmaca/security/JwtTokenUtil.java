package com.srmaca.security;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;
import java.util.Date;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

@Component
public class JwtTokenUtil {

    private String jwtSecret = "srmaca";
    private int jwtExpirationMs = 86400000;

    public String generateJwtToken(Authentication authentication) {
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);
        return Jwts.builder()
                .claim("sub", userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
    
    public boolean validateJwtToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            // Aquí manejas la excepción
            // Esto ocurre si hay algún problema con el token.
        }
    
        return false;
    }
    
}