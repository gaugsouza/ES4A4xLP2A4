package com.projeto.funancial.service;

import java.math.BigDecimal;

import com.projeto.funancial.model.Status;
import com.projeto.funancial.model.Usuario;
import com.projeto.funancial.repository.UsuarioRepository;

public class StatusService {

	private UsuarioRepository usuarioRepository;

	public StatusService(UsuarioRepository repository) {
		this.usuarioRepository = repository;
	}

	public Usuario aumentarExperienciaUsuario(Usuario usuario, Double experienciaGanha) {
		Status statusUsuario = usuario.getStatus();
		Double experienciaAtualizada = statusUsuario.getExperiencia() + experienciaGanha;
		Integer nivel = statusUsuario.getNivel();
		if (experienciaAtualizada > 100) {
			nivel += 1;
			experienciaAtualizada -= 100;
		}
		statusUsuario.setNivel(nivel);
		statusUsuario.setExperiencia(experienciaAtualizada);

		usuario.setStatus(statusUsuario);

		return usuarioRepository.save(usuario);
	}

	public Usuario alterarDinheiroUsuario(Usuario usuario, Double dinheiro) {
		Status statusUsuario = usuario.getStatus();
		Double dinheiroAtualizado = statusUsuario.getDinheiro().doubleValue() + dinheiro;
		statusUsuario.setDinheiro(BigDecimal.valueOf(dinheiroAtualizado));
		usuario.setStatus(statusUsuario);

		return usuarioRepository.save(usuario);
	}
}
