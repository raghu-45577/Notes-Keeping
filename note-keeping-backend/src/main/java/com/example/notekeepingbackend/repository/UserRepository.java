package com.example.notekeepingbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.notekeepingbackend.model.User;

public interface UserRepository extends MongoRepository<User, String>{
	

}
