package com.example.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

public interface SecurityConfigInterface {
    void configure(AuthenticationManagerBuilder auth) throws Exception;
}
