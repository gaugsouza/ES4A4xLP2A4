package com.projeto.funancial.util;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class EncriptadorServiceTest {
	private EncriptadorService encriptadorService = new EncriptadorService();
	
	@Test
	public void get_senha_encriptada_deve_retornar_uma_senha_encriptada() {
		//config
		String senha = "123";
		//exec
		String resultado = encriptadorService.getSenhaEncriptada(senha);
		//check
		/*TODO: TESTAR EncriptadorServiceTest*/
	}
}
