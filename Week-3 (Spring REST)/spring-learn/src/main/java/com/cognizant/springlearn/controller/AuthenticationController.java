package com.cognizant.springlearn.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import java.util.Date;
import javax.crypto.SecretKey;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
    @Value("${jwt.secret}")
    private String jwtSecret;

    private String generateJwt(String user) {
        LOGGER.debug("Start - generateJwt() : user = {}", user);

        SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        String token = Jwts.builder()
                .subject(user)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1200000)) // 20 minutes
                .signWith(key)
                .compact();

        LOGGER.debug("End - generateJwt() : token = {}", token);
        return token;
    }

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start - authenticate()");
        LOGGER.debug("authHeader = {}", authHeader);

        String user = getUser(authHeader);
        String token = generateJwt(user);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        LOGGER.info("End - authenticate()");
        return map;
    }
    
    private String getUser(String authHeader) {
        LOGGER.debug("Start - getUser() : authHeader = {}", authHeader);

        String encodedCredentials = authHeader.replace("Basic ", "");
        byte[] decodedBytes = java.util.Base64.getDecoder().decode(encodedCredentials);
        String decodedCredentials = new String(decodedBytes);

        String user = decodedCredentials.substring(0, decodedCredentials.indexOf(":"));

        LOGGER.debug("End - getUser() : user = {}", user);
        return user;
    }
}