package com.projeto.funancial.transformation;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.funancial.beanUtil.UsuarioBeanUtil;
import com.projeto.funancial.canonical.UsuarioCanonical;
import com.projeto.funancial.model.Usuario;

@Service
public class UsuarioTransformation {
	@Autowired
	private UsuarioBeanUtil usuarioBeanUtil;
	
	public Usuario convert(UsuarioCanonical usuarioCanonical) {
		return usuarioBeanUtil.toUsuario(usuarioCanonical);
	}
	
	public UsuarioCanonical convert(Usuario usuario) {
		return usuarioBeanUtil.toUsuarioCanonical(usuario);
	}
	
	public List<UsuarioCanonical> convert(Collection<Usuario> usuarios){
		return usuarios
				.stream()
				.map(this :: convert)
				.collect(Collectors.toList());
	}
}
