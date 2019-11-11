package com.projeto.funancial.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.funancial.canonical.UsuarioCanonical;
import com.projeto.funancial.model.Usuario;
import com.projeto.funancial.service.UsuarioService;
import com.projeto.funancial.util.EncriptadorService;

@RestController
@RequestMapping("/login")
public class LoginController {
	private UsuarioService usuarioService;
	private EncriptadorService encriptadorService;
	
	public LoginController(UsuarioService usuarioService, EncriptadorService encriptadorService) {
		this.usuarioService = usuarioService;
		this.encriptadorService = encriptadorService;
	}
	
	@PostMapping(value = "/")
	public ResponseEntity<Boolean> efetuaLogin(@RequestBody UsuarioCanonical usuarioCanonical) {
		List<Usuario> usuarios = usuarioService.findAll();
		Optional<Usuario> usuario = usuarios.stream()
			.filter(u -> usuarioCanonical.getEmail().equals(u.getEmail())).findFirst();
		
		if(!usuario.isPresent()) {
			return new ResponseEntity<Boolean>(false, HttpStatus.NO_CONTENT);
		}
		
		if(!encriptadorService.validaSenha(usuarioCanonical.getSenha(), 
				usuario.get().getSenha())) {
			return new ResponseEntity<Boolean>(false, HttpStatus.UNAUTHORIZED);
		}
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
