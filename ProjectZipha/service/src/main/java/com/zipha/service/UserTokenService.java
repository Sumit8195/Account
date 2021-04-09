package com.zipha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.zipha.model.AccountToken;
import com.zipha.repository.AccountTokenRepository;

@Service
public class UserTokenService {

    @Autowired
    private AccountTokenRepository userTokenRepository;

    public AccountToken save(AccountToken userToken) {
        return userTokenRepository.save(userToken);
    }

    public AccountToken getTokenById(String token) {
        return userTokenRepository.getByToken(token);
    }

    public void invalidateToken(AccountToken userToken) {
        userTokenRepository.delete(userToken);
    }
    
    
}
