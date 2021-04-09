package com.zipha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zipha.model.APIResponse;
import com.zipha.model.Account;
import com.zipha.model.AccountToken;
import com.zipha.service.AccountService;
import com.zipha.service.AuthService;

@RestController
public class AccountController extends BaseController{

	@Autowired 
	private AccountService service;
	@Autowired 
	private AuthService authService;
	
	@PostMapping(value="/api/v1/accm/account/")
	 public ResponseEntity<APIResponse> createAccount(
	            @RequestBody Account user
	    ) {
	       System.out.println("run");
	          
	           /*try {
	                passwordHash = MD5Hash.MD5Encrypt(authRequestModel.password + adminUser.getSalt());
	            } catch (NoSuchAlgorithmException ex) {
	                throw new RuntimeException("User login encrypt password error", ex);
	            }*/

	                    // TODO login
	                    AccountToken userToken = authService.createAccountToken(user, false);
	                    
	                    // Create Auth User -> Set to filter config
	                    // Perform the security
	                    String Id=service.create(user);
	                    //final Authentication authentication = authenticationManager.authenticate();
	                    
	                    return responseUtil.successResponse(userToken.getToken());
	                

	        
	    }
	
	
	
}
