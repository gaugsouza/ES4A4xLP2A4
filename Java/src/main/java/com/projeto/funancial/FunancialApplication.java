package com.projeto.funancial;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class FunancialApplication {
    private static final Logger logger = LogManager.getLogger();
    private static final String conUrl = "https://funancialprovisorio.firebaseio.com/"; 
		
	public static void main(String[] args) {
		try {
			FileInputStream serviceAccount =
					  new FileInputStream("C:\\Users\\GuilhermeAugustodeSo\\Documents\\Pessoal\\Faculdade\\funancialprovisorio-firebase-adminsdk-nef3z-a528a7e69d.json");
			FirebaseOptions options;
			logger.info("Inicializando a conexão com o firebase no endereço {}", conUrl);
			options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
			    .setDatabaseUrl(conUrl)
			    .build();
			FirebaseApp.initializeApp(options);
			logger.info("Conexão bem sucedida.");
			SpringApplication.run(FunancialApplication.class, args);
		} catch (IOException e) {
			logger.error("Conexão mal sucedida.");
			e.printStackTrace();
		}	

		
	}

}
