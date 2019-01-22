package com.hanafy.spring.webfluxmongodbexample;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import com.hanafy.spring.webfluxmongodbexample.model.Profile;
import com.hanafy.spring.webfluxmongodbexample.model.ProfileRepository;
import java.util.UUID;

@Component
//@org.springframework.context.annotation.Profile("demo") 
public class SampleDataInitializer
    implements ApplicationListener<ApplicationReadyEvent> {

	private final ProfileRepository repository; 
	private static final Logger log = LoggerFactory.getLogger(SampleDataInitializer.class);

    public SampleDataInitializer(ProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        repository
            .deleteAll() 
            .thenMany(
            		Flux.just("A", "B", "C", "D")
                    .map(name -> new Profile(UUID.randomUUID().toString(), name + "@email.com")) 
                    .flatMap(repository::save) 
            )
            .thenMany(repository.findAll()) 
            .subscribe(profile -> log.info("saving " + profile.toString())); 
    }

	
	 
   
}