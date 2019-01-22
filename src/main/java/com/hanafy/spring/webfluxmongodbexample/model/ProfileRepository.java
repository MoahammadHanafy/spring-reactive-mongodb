package com.hanafy.spring.webfluxmongodbexample.model;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProfileRepository extends ReactiveMongoRepository<Profile, String> {
	
}