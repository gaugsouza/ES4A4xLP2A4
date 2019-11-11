package com.projeto.funancial.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.projeto.funancial.canonical.UsuarioCanonical;
import com.projeto.funancial.model.Usuario;
import com.projeto.funancial.service.UsuarioService;
import com.projeto.funancial.util.EncriptadorService;

public class LoginControllerTest {
	private UsuarioService svc = Mockito.mock(UsuarioService.class);
	private EncriptadorService encrypt = Mockito.mock(EncriptadorService.class);
	private LoginController loginController = new LoginController(svc, encrypt);
	
	@Test
	public void efetua_login_bem_sucedido_deve_retornar_true() {
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
		ResponseEntity<Boolean> resultado = loginController.efetuaLogin(usuarioCanonical);
		//check
		assertEquals(true, resultado.getBody());
	}
	
	@Test
	public void efetua_login_bem_sucedido_deve_retornar_status_ok() {
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
		ResponseEntity<Boolean> resultado = loginController.efetuaLogin(usuarioCanonical);
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
		ResponseEntity<Boolean> resultado = loginController.efetuaLogin(usuarioCanonical);
		//check
		assertEquals(false, resultado.getBody());
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
		ResponseEntity<Boolean> resultado = loginController.efetuaLogin(usuarioCanonical);
		//check
		assertEquals(HttpStatus.NO_CONTENT, resultado.getStatusCode());
	}
	
	@Test
	public void efetua_login_mal_sucedido_por_senha_incorreta_deve_retornar_false() {
		//config
		UsuarioCanonical usuarioCanonical = UsuarioCanonical.builder()
												._id(ObjectId.get())
												.email("usuarioTeste@teste.com")
												.senha("123")												
												.build();		
		Usuario usuario = new Usuario(ObjectId.get(), "usuarioTeste@teste.com", "Jose", "Souza", "123");
		
		when(svc.findAll()).thenReturn(Arrays.asList(new Usuario(), usuario));
		when(encrypt.validaSenha(usuarioCanonical.getSenha(), usuario.getSenha())).thenReturn(false);
		//exec
		ResponseEntity<Boolean> resultado = loginController.efetuaLogin(usuarioCanonical);
		//check
		assertEquals(false, resultado.getBody());
	}
	
	@Test
	public void efetua_login_mal_sucedido_por_senha_incorreta_deve_retornar_status_unauthorized() {
		//config
		UsuarioCanonical usuarioCanonical = UsuarioCanonical.builder()
												._id(ObjectId.get())
												.email("usuarioTeste@teste.com")
												.senha("123")												
												.build();		
		Usuario usuario = new Usuario(ObjectId.get(), "usuarioTeste@teste.com", "Jose", "Souza", "123");
		
		when(svc.findAll()).thenReturn(Arrays.asList(new Usuario(), usuario));
		when(encrypt.validaSenha(usuarioCanonical.getSenha(), usuario.getSenha())).thenReturn(false);
		//exec
		ResponseEntity<Boolean> resultado = loginController.efetuaLogin(usuarioCanonical);
		//check
		assertEquals(HttpStatus.UNAUTHORIZED, resultado.getStatusCode());
	}
}
