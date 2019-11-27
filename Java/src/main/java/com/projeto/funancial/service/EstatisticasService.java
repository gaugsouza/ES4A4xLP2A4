package com.projeto.funancial.service;

import com.projeto.funancial.model.Status;
import com.projeto.funancial.model.Usuario;

public class EstatisticasService {
	public EstatisticasService() {
	}

	public Double gerarPorcentagemDinheiro(Usuario usuario) {
		Double dinheiroAtual = usuario.getDinheiro().doubleValue();
		Double calculoLucroPorcentagem = (dinheiroAtual / Status.DINHEIRO_INICIAL.doubleValue()) * 100;
		return calculoLucroPorcentagem;
	}

	public Double gerarPorcentagemExperiencia(Usuario usuario) {
		Double experienciaAtual = usuario.getExperiencia();
		Double porcentagemExperiencia = (experienciaAtual/Status.EXP_INICIAL)*100;
		return porcentagemExperiencia;
	}
	
	public Double gerarPorcentagemNivel(Usuario usuario) {
		Integer nivelAtual = usuario.getNivel();
		Double porcentagemNivel = (double) ((nivelAtual/Status.NIVEL_INICIAL)*100);
		return porcentagemNivel;
	}
}
