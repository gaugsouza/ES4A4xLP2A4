package com.projeto.funancial.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.projeto.funancial.canonical.UsuarioCanonical;
import com.projeto.funancial.exception.EncriptadorServiceException;
import com.projeto.funancial.model.Usuario;
import com.projeto.funancial.service.AuthenticationService;
import com.projeto.funancial.service.EncriptadorService;
import com.projeto.funancial.service.UsuarioService;

public class LoginControllerTest {
	private UsuarioService svc = Mockito.mock(UsuarioService.class);
	private EncriptadorService encrypt = Mockito.mock(EncriptadorService.class);
	private AuthenticationService auth = Mockito.mock(AuthenticationService.class); 
	private LoginController loginController = new LoginController(svc, encrypt, auth);
	
	@Test
	public void efetua_login_bem_sucedido_deve_retornar_true() throws EncriptadorServiceException {
		//config
		UsuarioCanonical usuarioCanonical = UsuarioCanonical.builder()
												._id(ObjectId.get())
												.email("usuarioTeste@teste.com")
												.senha("123")												
												.build();
		Usuario usuario = new Usuario(ObjectId.get(), "usuarioTeste@teste.com", "Jose", "Souza", "123");
		when(svc.findAll()).thenReturn(Arrays.asList(new Usuario(), usuario));
		when(encrypt.validaSenha(usuarioCanonical.getSenha(), usuario.getSenha())).thenReturn(true);
		//exec
		ResponseEntity<UsuarioCanonical> resultado = loginController.efetuaLogin(usuarioCanonical);
		//check
		assertEquals(usuarioCanonical, resultado.getBody());
	}
	
	@Test
	public void efetua_login_bem_sucedido_deve_retornar_status_ok() throws EncriptadorServiceException {
		//config
		UsuarioCanonical usuarioCanonical = UsuarioCanonical.builder()
												._id(ObjectId.get())
												.email("usuarioTeste@teste.com")
												.senha("123")												
												.build();		
		Usuario usuario = new Usuario(ObjectId.get(), "usuarioTeste@teste.com", "Jose", "Souza", "123");		
		when(svc.findAll()).thenReturn(Arrays.asList(new Usuario(), usuario));
		when(encrypt.validaSenha(usuarioCanonical.getSenha(), usuario.getSenha())).thenReturn(true);
		//exec
		ResponseEntity<UsuarioCanonical> resultado = loginController.efetuaLogin(usuarioCanonical);
		//check
		assertEquals(HttpStatus.OK, resultado.getStatusCode());
	}
	
	@Test
	public void efetua_login_mal_sucedido_por_email_nao_encontrado_deve_retornar_false() {
		//config
		UsuarioCanonical usuarioCanonical = UsuarioCanonical.builder()
												._id(ObjectId.get())
												.email("usuarioInexistente@teste.com")
												.senha("123")												
												.build();		
		Usuario usuario = new Usuario(ObjectId.get(), "usuarioTeste@teste.com", "Jose", "Souza", "123");
		
		when(svc.findAll()).thenReturn(Arrays.asList(new Usuario(), usuario));
		//exec
		ResponseEntity<UsuarioCanonical> resultado = loginController.efetuaLogin(usuarioCanonical);
		//check
		assertEquals(usuarioCanonical, resultado.getBody());
	}
	
	@Test
	public void efetua_login_mal_sucedido_por_email_nao_encontrado_deve_retornar_status_no_content() {
		//config
		UsuarioCanonical usuarioCanonical = UsuarioCanonical.builder()
												._id(ObjectId.get())
												.email("usuarioInexistente@teste.com")
												.senha("123")												
												.build();		
		Usuario usuario = new Usuario(ObjectId.get(), "usuarioTeste@teste.com", "Jose", "Souza", "123");
		
		when(svc.findAll()).thenReturn(Arrays.asList(new Usuario(), usuario));
		//exec
		ResponseEntity<UsuarioCanonical> resultado = loginController.efetuaLogin(usuarioCanonical);
		//check
		assertEquals(HttpStatus.NO_CONTENT, resultado.getStatusCode());
	}
	
	@Test
	public void efetua_login_mal_sucedido_por_senha_incorreta_deve_retornar_false() throws EncriptadorServiceException {
		//config
		UsuarioCanonical usuarioCanonical = UsuarioCanonical.builder()
												._id(ObjectId.get())
												.email("usuarioTeste@teste.com")
												.senha("123")												
												.build();		
		Usuario usuario = new Usuario(ObjectId.get(), "usuarioTeste@teste.com", "Jose", "Souza", "125");
		
		when(svc.findAll()).thenReturn(Arrays.asList(new Usuario(), usuario));
		when(encrypt.validaSenha(usuarioCanonical.getSenha(), usuario.getSenha())).thenReturn(false);
		//exec
		ResponseEntity<UsuarioCanonical> resultado = loginController.efetuaLogin(usuarioCanonical);
		//check
		assertEquals(usuarioCanonical, resultado.getBody());
	}
	
	@Test
	public void efetua_login_mal_sucedido_por_senha_incorreta_deve_retornar_status_unauthorized() 
			throws EncriptadorServiceException {
		//config
		UsuarioCanonical usuarioCanonical = UsuarioCanonical.builder()
												._id(ObjectId.get())
												.email("usuarioTeste@teste.com")
												.senha("123")												
												.build();		
		Usuario usuario = new Usuario(ObjectId.get(), "usuarioTeste@teste.com", "Jose", "Souza", "125");
		
		when(svc.findAll()).thenReturn(Arrays.asList(new Usuario(), usuario));
		when(encrypt.validaSenha(usuarioCanonical.getSenha(), usuario.getSenha())).thenReturn(false);
		//exec
		ResponseEntity<UsuarioCanonical> resultado = loginController.efetuaLogin(usuarioCanonical);
		//check
		assertEquals(HttpStatus.UNAUTHORIZED, resultado.getStatusCode());
	}
	
	@Test
	public void efetua_login_mal_sucedido_por_excecao_durante_validacao_de_senha_deve_retornar_false() 
			throws EncriptadorServiceException{
		//config
		UsuarioCanonical usuarioCanonical = UsuarioCanonical.builder()
				._id(ObjectId.get())
				.email("usuarioTeste@teste.com")
				.senha("123")												
				.build();		
		Usuario usuario = new Usuario(ObjectId.get(), "usuarioTeste@teste.com", "Jose", "Souza", "123");

		when(svc.findAll()).thenReturn(Arrays.asList(new Usuario(), usuario));
		when(encrypt.validaSenha(usuarioCanonical.getSenha(), usuario.getSenha())).thenThrow(EncriptadorServiceException.class);
		//exec
		ResponseEntity<UsuarioCanonical> resultado = loginController.efetuaLogin(usuarioCanonical);
		//check
		assertEquals(usuarioCanonical, resultado.getBody());
	}
	
	@Test
	public void efetua_login_mal_sucedido_por_excecao_durante_validacao_de_senha_deve_retornar_status_internal_server_error() 
			throws EncriptadorServiceException{
		//config
		UsuarioCanonical usuarioCanonical = UsuarioCanonical.builder()
				._id(ObjectId.get())
				.email("usuarioTeste@teste.com")
				.senha("123")												
				.build();		
		Usuario usuario = new Usuario(ObjectId.get(), "usuarioTeste@teste.com", "Jose", "Souza", "123");

		when(svc.findAll()).thenReturn(Arrays.asList(new Usuario(), usuario));
		when(encrypt.validaSenha(usuarioCanonical.getSenha(), usuario.getSenha())).thenThrow(EncriptadorServiceException.class);
		//exec
		ResponseEntity<UsuarioCanonical> resultado = loginController.efetuaLogin(usuarioCanonical);
		//check
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, resultado.getStatusCode());
	}
}
