package com.zipha.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zipha.model.AccountToken;



@Repository
public interface AccountTokenRepository extends MongoRepository<AccountToken, String> {

	AccountToken getByToken(String token);
	AccountToken getAccountTokenById(String id);



}
