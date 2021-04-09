/*
 * Copyright (c) NIT-Software. All Rights Reserved.
 * This software is the confidential and proprietary information of NIT-Software,
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with NIT-Software.
 */
package com.zipha.service;


import com.zipha.exception.ApplicationException;
import com.zipha.model.Account;
import com.zipha.model.AccountToken;
import com.zipha.model.AuthUser;
import com.zipha.model.AuthUserFactory;
import com.zipha.repository.AccountRepository;
import com.zipha.repository.AccountTokenRepository;
import com.zipha.util.APIStatus;
import com.zipha.util.Constant;
import com.zipha.util.DateUtil;
import com.zipha.util.UniqueID;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public class AuthServiceImpl extends AbstractBaseService implements AuthService{
    
    @Autowired
    AccountRepository userRepository;
    
    @Autowired
    private AccountTokenRepository userTokenRepository;
    
    @Autowired
    AuthUserFactory authUserFactory;
    
    @Override
    public AccountToken createAccountToken (Account userLogin, boolean keepMeLogin){
        try {
        	keepMeLogin=true;
        	AccountToken userToken = new AccountToken();
            userToken.setToken(UniqueID.getUUID());
            
            userToken.setUserId(userLogin.getUser_Id());
            Date currentDate = new Date();
            userToken.setLoginDate(DateUtil.convertToUTC(currentDate));
            Date expirationDate = keepMeLogin ? new Date(currentDate.getTime() + Constant.DEFAULT_REMEMBER_LOGIN_MILISECONDS) : new Date(currentDate.getTime() + Constant.DEFAULT_SESSION_TIME_OUT);
            userToken.setExpirationDate(DateUtil.convertToUTC(expirationDate));
            AuthUser authUser = authUserFactory.createAuthUser(userLogin);
            // Set authUser to session data...
            userToken.setSessionData(gson.toJson(authUser));
            userTokenRepository.save(userToken);
            System.out.println("AuthServiceIml end");
            return userToken;
        } catch (Exception e) {
            LOGGER.error("Error create User token ", e);
            throw new ApplicationException(APIStatus.SQL_ERROR);
        }
    }

  
	

	@Override
	public AccountToken getUserTokenById(String id) {
		return userTokenRepository.getAccountTokenById(id);
	}

	@Override
	public void deleteUserToken(AccountToken userToken) {
		// TODO Auto-generated method stub
		
	}
    
}
