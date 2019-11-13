package com.projeto.funancial;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FunancialApplication {
    private static final Logger logger = LogManager.getLogger();
    		
	public static void main(String[] args) {
		SpringApplication.run(FunancialApplication.class, args);	
	}

}