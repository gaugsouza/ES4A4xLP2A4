package com.projeto.funancial.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

public class JWTUtil {
	public static boolean isJwtTokenValid(String jwtSecret, String issuer, String jwtToken) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
		    JWTVerifier verifier = JWT.require(algorithm)
		        .withIssuer(issuer)
		        .build();
		    
		    verifier.verify(jwtToken);
		    
		    return true;
		} catch(JWTVerificationException e) {
			return false;
		}			
	}
	
	public static String createJwtToken(String jwtSecret, String issuer) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
		
			return JWT.create()
					.withIssuer(issuer)
					.sign(algorithm);
		} catch (JWTCreationException e) {
			throw new JWTCreationException(e.getMessage(), e.getCause());
		}
	}
}
