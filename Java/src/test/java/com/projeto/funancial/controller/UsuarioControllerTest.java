package com.projeto.funancial.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.projeto.funancial.service.UsuarioService;

@RunWith(SpringRunner.class)
@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {
	@Autowired
	private MockMvc mockMvc;	
	@MockBean
	private UsuarioController usuarioController;	
	
	@Test
	public void getUsuarios() {
		UsuarioService svc = Mockito.mock(UsuarioService.class);
		
		when(svc.findAll()).thenResult(null);//)
		
		usuarioController = new UsuarioController(svc);
		
	}
	
	@Test
	public void getUsuarioById() {
		
	}

	@Test
	public void createUsuario() {
		
	}
	
	@Test
	public void modifyUsuario() {
		
	}
	
	@Test
	public void deleteUsuario() {
		
	}
}
