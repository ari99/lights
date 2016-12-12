package com.me.light;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.me.light.loop.LightLooper;


@Component
public class ApplicationRunner implements CommandLineRunner {
    
	private LightLooper looper;
	
	@Autowired
	public ApplicationRunner( LightLooper looper){
		this.looper = looper;
	}
	
	public void run(String... args) {
		this.looper.start();
	}

}
