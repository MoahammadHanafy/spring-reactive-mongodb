package com.hanafy.spring.webfluxmongodbexample.service;

import org.springframework.context.ApplicationEvent;

import com.hanafy.spring.webfluxmongodbexample.model.Profile;

public class ProfileCreatedEvent extends ApplicationEvent {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProfileCreatedEvent(Profile source) {
        super(source);
    }
}