package com.projeto.funancial.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.projeto.funancial.model.Usuario;
import com.projeto.funancial.repository.UsuarioRepository;

@Component
public class DBLoader implements CommandLineRunner{
	private final UsuarioRepository rep;
	
	@Autowired
	public DBLoader(UsuarioRepository rep) {
		this.rep = rep;
	}
	
	@Override
	public void run(String... strings) throws Exception{
		this.rep.save(new Usuario("João", "Ferreira", "joao.ferreira@teste.com", "jota123#$"));
	}
}
