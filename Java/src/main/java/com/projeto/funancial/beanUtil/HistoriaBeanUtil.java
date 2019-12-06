package com.projeto.funancial.beanUtil;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.projeto.funancial.model.Historia;
import com.projeto.funancial.transformation.OpcaoTransformation;

/**
 * A classe <code>HistoriaBeanUtil</code> é responsável por operações utilitárias que 
 * englobam os objetos Historia e seus representantes em JSON 
 *
 * @author guilhermeguis@outlook.com
 * @version 1.0
 * @since JDK1.8
 */
@Service
public class HistoriaBeanUtil {
	private OpcaoTransformation opcaoTransformation;
	
	/**
     * Transforma um objeto JSON de historia em outro objeto do tipo Historia.
     *
     * @param JSONObject historiaJSON - Será transformado em Historia.
     * @return Historia - JSONObject de historia transformado em Historia.
     */
	public Historia toHistoria(JSONObject historiaJSON) {
		JSONObject historia = historiaJSON.getJSONObject("historia");
		
		return Historia
				.builder()
				.titulo(historia.getString("titulo"))
				.opcoes(opcaoTransformation.convert(historia.getJSONArray("opcoes")))
				.build();
	}
}
