package com.projeto.funancial.service;

import com.projeto.funancial.model.Status;
import com.projeto.funancial.model.Usuario;

public class EstatisticasService {
	public EstatisticasService() {
	}

	public Double gerarEstatisticaDinheiro(Usuario usuario) {
		Double dinheiroAtual = usuario.getDinheiro().doubleValue();
		Double diferencaDinheiro = dinheiroAtual >= Status.DINHEIRO_INICIAL.doubleValue()
				? dinheiroAtual - Status.DINHEIRO_INICIAL.doubleValue()
				: Status.DINHEIRO_INICIAL.doubleValue() - dinheiroAtual;
		return diferencaDinheiro;
	}

	public Integer gerarEstatisticaNivel(Usuario usuario) {
		Integer nivelAtual = usuario.getNivel();
		Integer diferencaNivel = nivelAtual - Status.NIVEL_INICIAL;
		return diferencaNivel;
	}
}
