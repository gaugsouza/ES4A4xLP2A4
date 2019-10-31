package com.projeto.funancial.util;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class EncriptadorService {
	private static final Logger logger = LogManager.getLogger();
	
	public String getSenhaEncriptada(String senha) {
		int iterations = 1000;
	    char[] chars = senha.toCharArray();
	    
	    try {
	    	byte[] salt = getSalt();
	    	PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
		    SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		    byte[] hash = skf.generateSecret(spec).getEncoded();
		    
		    return iterations + ":" + toHex(salt) + ":" + toHex(hash);		    
		} catch (NoSuchAlgorithmException e) {
			logger.error("Serviço de criptografia falhou - NoSuchAlgorithmException.\nErro: {}", e.getMessage());
		} catch (InvalidKeySpecException  e) {
			logger.error("Serviço de criptografia falhou - InvalidKeySpecException.\nErro: {}", e.getMessage());
		}
	    
	    return senha;	    
	}
	
	public boolean validaSenha(String senhaOriginal, String senhaArmazenada) {
		String[] parts = senhaArmazenada.split(":");
        int iterations = Integer.parseInt(parts[0]);
        try {
        	byte[] salt = fromHex(parts[1]);
            byte[] hash = fromHex(parts[2]);
             
            PBEKeySpec spec = new PBEKeySpec(senhaOriginal.toCharArray(), salt, iterations, hash.length * 8);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] testHash = skf.generateSecret(spec).getEncoded();
             
            int diff = hash.length ^ testHash.length;
            for(int i = 0; i < hash.length && i < testHash.length; i++) {
                diff |= hash[i] ^ testHash[i];
            }
            
            return diff == 0;            
		} catch (NoSuchAlgorithmException e) {
			logger.error("Serviço de criptografia falhou - NoSuchAlgorithmException.\nErro: {}", e.getMessage());
		} catch (InvalidKeySpecException e) {
			logger.error("Serviço de criptografia falhou - InvalidKeySpecException.\nErro: {}", e.getMessage());
        }
        
        return false;
    }
    	
	private byte[] getSalt() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
	    byte[] salt = new byte[16];
	    sr.nextBytes(salt);
	    return salt;
	}
	     
	private String toHex(byte[] array) throws NoSuchAlgorithmException {
		BigInteger bi = new BigInteger(1, array);
	    String hex = bi.toString(16);
	    int paddingLength = (array.length * 2) - hex.length();
	    if(paddingLength > 0) {
	    	return String.format("%0"  +paddingLength + "d", 0) + hex;
	    } else {
	    	return hex;
	    }
	}
	
	private byte[] fromHex(String hex) throws NoSuchAlgorithmException {
        byte[] bytes = new byte[hex.length() / 2];
        for(int i = 0; i<bytes.length ;i++) {
            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
}
