package com.projeto.funancial.transformation;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.projeto.funancial.beanUtil.OpcaoBeanUtil;
import com.projeto.funancial.model.Opcao;

/**
 * A classe <code>OpcaoTransformation</code> é utilizada com o fim de reduzir acoplamento.
 *
 * @author guilhermeguis@outlook.com
 * @version 1.0
 * @since JDK1.8
 */
@Service
public class OpcaoTransformation {
	private OpcaoBeanUtil opcaoBeanUtil;
	
	public OpcaoTransformation(OpcaoBeanUtil opcaoBeanUtil) {
		this.opcaoBeanUtil = opcaoBeanUtil;
	}
	
	/**
     * Transforma um JSONObject de opção em uma Opcao.
     *
     * @param JSONObject opcaoJSON - Será transformado em Opcao.
     * @return Opcao - JSONObject de opção transformado em Opcao.
     */
	public Opcao convert(JSONObject opcaoJSON) {
		return opcaoBeanUtil.toOpcao(opcaoJSON);
	}
	
	/**
     * Transforma um JSONArray com opções em uma lista de opção.
     *
     * @param JSONArray opcoesJSON - Será transformado em List<Opcao>.
     * @return List<Opcao> - JSONArray com opções transformado em List<Opcao>.
     */
	public List<Opcao> convert(JSONArray opcoesJSON) {
		return opcaoBeanUtil.toOpcaoList(opcoesJSON);
	}
}
