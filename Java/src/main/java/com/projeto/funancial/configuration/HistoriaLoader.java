package com.projeto.funancial.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.funancial.service.HistoriaService;
import com.projeto.funancial.transformation.HistoriaTransformation;

@Service
public class HistoriaLoader {
	@Autowired
	private HistoriaTransformation historiaTransformation;
	@Autowired
	private HistoriaService historiaService; 
	
	public void loadHistorias() {	
		Logger logger = LogManager.getLogger(ConfigurationPropertyFactory.class);
		
		try(InputStream input = new FileInputStream(ConfigurationPropertyFactory.class
				.getClassLoader()
				.getResource("historias.json")
				.getFile())) {
			JSONArray historias = new JSONObject(IOUtils.toString(input, "UTF-8")).getJSONArray("historias");
										
			historias.forEach(historia -> historiaService.save(
					historiaTransformation.convert((JSONObject) historia)));
		} catch(IOException e) {
			logger.error("Erro durante o carregamento de configurações do arquivo historias.json");
		}
	}

}