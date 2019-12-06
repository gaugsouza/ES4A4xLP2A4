package com.projeto.funancial;

import static com.projeto.funancial.configuration.ConfigurationPropertyFactory.getConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.funancial.configuration.HistoriaLoader;

/**
 * � Copyright Beta IT 2019<br>
 *
 * A classe <code>FunancialApplication</code> � utilizada como inicializadora do backend
 * da aplica��o.
 *
 * @author guilhermeguis@outlook.com
 * @version 1.0
 * @since JDK1.8
 */
@SpringBootApplication
public class FunancialApplication {   		
	public static void main(String[] args) {
		getConfiguration();
		
		HistoriaLoader historiaLoader = new HistoriaLoader();
		historiaLoader.loadHistorias();
		
		SpringApplication.run(FunancialApplication.class, args);	
	}
}