/*
 * Copyright (c) NIT-Software. All Rights Reserved.
 * This software is the confidential and proprietary information of NIT-Software,
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with NIT-Software.
 */
package com.zipha.model;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zipha.repository.RoleRepository;



@Service
public class AuthUserFactoryImpl implements AuthUserFactory{
    @Autowired
    RoleRepository roleRepository;
    
    @Override
    public AuthUser createAuthUser(Account user) {
        return new AuthUser(
                    user.getUser_Id(),
                    user.getEmail(),
                    user.getPassword(),
                   // getUserRoleString(user.getAccount_Type()),
                    user.getAccount_Type(),
                    
                    user.getFirstName(),
                    user.getLastName()
                   
            );
    }

    
}
