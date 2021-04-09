package com.zipha.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.zipha.config.AppConfig;
import com.zipha.model.AuthUser;
import com.zipha.service.CustomUserAuthService;
import com.zipha.util.Constant;
import com.zipha.util.ResponseUtil;

public abstract class BaseController {
	
	
	private CustomUserAuthService userDetailsService;
	
	
	@Autowired
	AppConfig aapConfig;
	
	
	@Autowired 
	protected ResponseUtil responseUtil;
	
	public AuthUser getAuthUserFromSession(HttpServletRequest request)
	{
		System.out.println("Base Success");
		String authToken = request.getHeader(Constant.HEADER_TOKEN);
        // try to load sessio
        AuthUser user = userDetailsService.loadUserByAccessToken(authToken);
        return user;
	}

}
