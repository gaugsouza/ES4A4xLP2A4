package com.projeto.funancial.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.funancial.canonical.UsuarioCanonical;
import com.projeto.funancial.exception.AuthenticationServiceException;
import com.projeto.funancial.exception.EncriptadorServiceException;
import com.projeto.funancial.model.Usuario;
import com.projeto.funancial.service.AuthenticationService;
import com.projeto.funancial.service.EncriptadorService;
import com.projeto.funancial.service.UsuarioService;

@RestController
@RequestMapping("/login")
public class LoginController {
	private UsuarioService usuarioService;
	private EncriptadorService encriptadorService;
	private AuthenticationService authenticationService;
	
	public LoginController(UsuarioService usuarioService, EncriptadorService encriptadorService,
			AuthenticationService authenticationService) {
		this.usuarioService = usuarioService;
		this.encriptadorService = encriptadorService;
		this.authenticationService = authenticationService;
	}
	
    private final Logger logger = LogManager.getLogger(LoginController.class);
	
	@PostMapping(value = "/")
	public ResponseEntity<UsuarioCanonical> efetuaLogin(@RequestBody UsuarioCanonical usuarioCanonical) {
		if(usuarioCanonical.getJwtToken() != null) {
			if(!authenticationService.validaToken(usuarioCanonical))
				return new ResponseEntity<UsuarioCanonical>(usuarioCanonical, HttpStatus.UNAUTHORIZED);	
			
			return new ResponseEntity<UsuarioCanonical>(usuarioCanonical, HttpStatus.OK);							
		}
		
		List<Usuario> usuarios = usuarioService.findAll();
		Optional<Usuario> usuario = usuarios.stream()
			.filter(u -> usuarioCanonical.getEmail().equals(u.getEmail())).findFirst();
		
		if(!usuario.isPresent()) {
			return new ResponseEntity<UsuarioCanonical>(usuarioCanonical, HttpStatus.NO_CONTENT);
		}
		
		try {
			if(!encriptadorService.validaSenha(usuarioCanonical.getSenha(), usuario.get().getSenha()))
				return new ResponseEntity<UsuarioCanonical>(usuarioCanonical, HttpStatus.UNAUTHORIZED);
		
			usuarioCanonical.setJwtToken(authenticationService.geraToken(usuarioCanonical));
			
			return new ResponseEntity<UsuarioCanonical>(usuarioCanonical, HttpStatus.OK);
		} catch(EncriptadorServiceException e) {
			logger.error("Erro encontrado durante a valida��o da senha informada:\n" + e.getMessage()
					+ "\nCausa:\n" + e.getCause());
			
			return new ResponseEntity<UsuarioCanonical>(usuarioCanonical, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch(AuthenticationServiceException e) {
			logger.error("Erro encontrado durante a gera��o de token: \n" + e.getMessage()
			+ "\nCausa:\n" + e.getCause());
			
			return new ResponseEntity<UsuarioCanonical>(usuarioCanonical, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}