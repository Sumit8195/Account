package com.zipha.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zipha.model.Account;
import com.zipha.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired 
	private AccountRepository repo;

	public String create(Account account) {
		Account acc = new Account();
		acc=repo.save(account);
		return acc.getUser_Id();
	}

	public Account findById(String id) throws Exception {
		Optional<Account> acc=repo.findById(id);
		if(acc.isPresent())
		return acc.get();
		else
			throw new Exception("Bad Credientials");
	}

	
}
