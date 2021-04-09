package com.zipha.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.zipha.model.AuthUser;

public interface CustomUserAuthService extends UserDetailsService{
    AuthUser loadUserByAccessToken(String token);
}
