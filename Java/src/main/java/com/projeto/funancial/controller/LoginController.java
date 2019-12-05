package com.projeto.funancial.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.projeto.funancial.transformation.UsuarioTransformation;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins =  "*" )
public class LoginController {
	private UsuarioService usuarioService;
	private EncriptadorService encriptadorService;
	private AuthenticationService authenticationService;
	private UsuarioTransformation usuarioTransformation;

	public LoginController(UsuarioService usuarioService, EncriptadorService encriptadorService,
			AuthenticationService authenticationService, UsuarioTransformation usuarioTransformation) {
		this.usuarioService = usuarioService;
		this.encriptadorService = encriptadorService;
		this.authenticationService = authenticationService;
		this.usuarioTransformation = usuarioTransformation;
	}

	private final Logger logger = LogManager.getLogger(LoginController.class);

	@PostMapping(value = "")
	public ResponseEntity<UsuarioCanonical> efetuaLogin(@RequestBody UsuarioCanonical usuarioCanonical) {
		if (Optional.ofNullable(usuarioCanonical.getJwt()).isPresent()
				&& authenticationService.validaToken(usuarioCanonical))
			return new ResponseEntity<UsuarioCanonical>(usuarioCanonical, HttpStatus.OK);

		Optional<Usuario> usuario = usuarioService.findAll().stream()
				.filter(u -> usuarioCanonical.getEmail().equals(u.getEmail())).findFirst();

		if (!usuario.isPresent())
			return new ResponseEntity<UsuarioCanonical>(usuarioCanonical, HttpStatus.NO_CONTENT);

		try {
			if (!encriptadorService.validaSenha(usuarioCanonical.getSenha(), usuario.get().getSenha()))
				return new ResponseEntity<UsuarioCanonical>(usuarioCanonical, HttpStatus.UNAUTHORIZED);

			UsuarioCanonical usuarioConvert = usuarioTransformation.convert(usuario.get());			
			usuarioConvert.setJwt(authenticationService.geraToken(usuarioConvert));

			return new ResponseEntity<UsuarioCanonical>(usuarioConvert, HttpStatus.OK);
		} catch (EncriptadorServiceException e) {
			logger.error("Erro encontrado durante a valida��o da senha informada:\n" + e.getMessage() + "\nCausa:\n"
					+ e.getCause());

			return new ResponseEntity<UsuarioCanonical>(usuarioCanonical, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (AuthenticationServiceException e) {
			logger.error("Erro encontrado durante a gera��o de token: \n" + e.getMessage() + "\nCausa:\n"
					+ e.getCause());

			return new ResponseEntity<UsuarioCanonical>(usuarioCanonical, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/cadastro")
	public ResponseEntity<UsuarioCanonical> efetuaCadastro(@RequestBody UsuarioCanonical usuarioCanonical) {
		Optional<Usuario> usuario = usuarioService.findAll().stream()
				.filter(u -> usuarioCanonical.getEmail().equals(u.getEmail())).findFirst();

		if (usuario.isPresent())
			return new ResponseEntity<UsuarioCanonical>(usuarioCanonical, HttpStatus.CONFLICT);

		try {
			usuarioCanonical.set_id(ObjectId.get());
			usuarioCanonical.setSenha(encriptadorService.geraSenhaEncriptada(usuarioCanonical.getSenha()));
			usuarioCanonical.setJwt(authenticationService.geraToken(usuarioCanonical));

			Usuario usuarioSalvo = usuarioService.save(usuarioTransformation.convert(usuarioCanonical));
			UsuarioCanonical canonicalSalvo = usuarioTransformation.convert(usuarioSalvo);
			canonicalSalvo.setJwt(usuarioCanonical.getJwt());
			
			return new ResponseEntity<UsuarioCanonical>(canonicalSalvo, HttpStatus.OK);
			
		} catch (EncriptadorServiceException e) {
			logger.error("Erro encontrado durante a gera��o da senha informada:\n" + e.getMessage() + "\nCausa:\n"
					+ e.getCause());

			return new ResponseEntity<UsuarioCanonical>(usuarioCanonical, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (AuthenticationServiceException e) {
			logger.error("Erro encontrado durante a gera��o de token: \n" + e.getMessage() + "\nCausa:\n"
					+ e.getCause());

			return new ResponseEntity<UsuarioCanonical>(usuarioCanonical, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
