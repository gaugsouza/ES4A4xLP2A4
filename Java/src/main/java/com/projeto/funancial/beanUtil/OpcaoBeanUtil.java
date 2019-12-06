package com.projeto.funancial.beanUtil;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.projeto.funancial.model.Opcao;
/**
 * A classe <code>OpcaoBeanUtil</code> � respons�vel por opera��es utilit�rias que 
 * englobam os objetos Opcao e seus representantes em JSON
 *
 * @author guilhermeguis@outlook.com
 * @version 1.0
 * @since JDK1.8
 */
@Service
public class OpcaoBeanUtil {
	/**
     * Transforma um JSONObject de op��o em uma Opcao.
     *
     * @param JSONObject opcaoJSON - Ser� transformado em Opcao.
     * @return Opcao - JSONObject de op��o transformado em Opcao.
     */
	public Opcao toOpcao(JSONObject opcaoJSON) {
		JSONObject opcao = opcaoJSON.getJSONObject("opcao");
		
		return Opcao
				.builder()
				.descricao(opcao.getString("descricao"))
				.experiencia(opcao.getInt("experiencia"))
				.vida(opcao.getInt("vida"))
				.dinheiro(opcao.getInt("dinheiro"))
				.build();
	}
	
	/**
     * Transforma um JSONArray com op��es em uma lista de op��o.
     *
     * @param JSONArray opcoesJSON - Ser� transformado em List<Opcao>.
     * @return List<Opcao> - JSONArray com op��es transformado em List<Opcao>.
     */
	public List<Opcao> toOpcaoList(JSONArray opcoesJSON) {
		List<Opcao> opcoes = new ArrayList<>();	
		opcoesJSON.forEach(opcaoJSON -> opcoes.add(this.toOpcao((JSONObject) opcaoJSON)));
		
		return opcoes;
	}	
}
