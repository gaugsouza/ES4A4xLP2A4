package com.projeto.funancial;

import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Configuration
public class ApplicationConfig {
	@Getter
	private String jwtSecret;
}
