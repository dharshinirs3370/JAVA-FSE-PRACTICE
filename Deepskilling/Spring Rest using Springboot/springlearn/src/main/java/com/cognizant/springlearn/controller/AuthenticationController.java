package com.cognizant.springlearn.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.AuthenticationResponse;
import com.cognizant.springlearn.util.JwtUtil;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public AuthenticationResponse authenticate(
            @RequestHeader("Authorization") String authorizationHeader) {

        LOGGER.info("Start Authentication");

        String encoded =
                authorizationHeader.substring("Basic ".length());

        byte[] decodedBytes =
                Base64.getDecoder().decode(encoded);

        String credentials =
                new String(decodedBytes, StandardCharsets.UTF_8);

        String username =
                credentials.split(":")[0];

        String token =
                jwtUtil.generateToken(username);

        LOGGER.info("JWT Generated");

        return new AuthenticationResponse(token);
    }
}