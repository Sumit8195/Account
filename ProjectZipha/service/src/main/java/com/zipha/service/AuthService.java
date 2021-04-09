/*
 * Copyright (c) NIT-Software. All Rights Reserved.
 * This software is the confidential and proprietary information of NIT-Software,
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with NIT-Software.
 */
package com.zipha.service;

import com.zipha.model.Account;
import com.zipha.model.AccountToken;


public interface AuthService {
    
  //  public Account getUserByUserIdAndEmailAndStatus (String email, Long User_Id, int status);

    public AccountToken createAccountToken(Account adminUser, boolean keepMeLogin);
    
 //   public User getUserByUserIdAndCompanyIdAndStatus (String userId, Long companyId, int status);
    
    public AccountToken getUserTokenById (String id);
    
    public void deleteUserToken (AccountToken userToken);
}
