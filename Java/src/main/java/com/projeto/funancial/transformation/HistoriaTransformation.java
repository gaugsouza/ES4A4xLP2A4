package com.projeto.funancial.transformation;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.projeto.funancial.beanUtil.HistoriaBeanUtil;
import com.projeto.funancial.model.Historia;

/**
 * A classe <code>HistoriaTransformation</code> � utilizada com o fim de reduzir acoplamento.
 *
 * @author guilhermeguis@outlook.com
 * @version 1.0
 * @since JDK1.8
 */
@Service
public class HistoriaTransformation {
	private HistoriaBeanUtil historiaBeanUtil;
	
	public HistoriaTransformation(HistoriaBeanUtil historiaBeanUtil) {
		this.historiaBeanUtil = historiaBeanUtil;
	}
	
	/**
     * Transforma um JSONObject de hist�ria em uma Historia.
     *
     * @param JSONObject historiaJSON - Ser� transformado em Historia.
     * @return Historia - JSONObject de hist�ria transformado em Historia.
     */
	public Historia convert(JSONObject historiaJSON) {
		return historiaBeanUtil.toHistoria(historiaJSON);
	}
}
