package com.projeto.funancial.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.funancial.model.Usuario;
import com.projeto.funancial.repository.UsuarioRepository;
import com.projeto.funancial.util.EncriptadorService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private EncriptadorService encriptadorService;
	private static final Logger logger = LogManager.getLogger();
	  
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Usuario getUsuarioById(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}
	  
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyUsuario(@PathVariable("id") ObjectId id, @Valid @RequestBody Usuario usuario) {
		usuario.set_id(id);
		repository.save(usuario);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Usuario createUsuario(@Valid @RequestBody Usuario usuario) {
		String senhaEncriptada = encriptadorService.getSenhaEncriptada(usuario.getSenha());
		if(senhaEncriptada.equals(usuario.getSenha())) {
			return usuario;
		}
		usuario.set_id(ObjectId.get());
		usuario.setSenha(senhaEncriptada);
		repository.save(usuario);
		return usuario;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteUsuario(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
	}
}
