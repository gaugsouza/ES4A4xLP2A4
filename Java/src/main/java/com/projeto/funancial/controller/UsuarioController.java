package com.projeto.funancial.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.funancial.canonical.UsuarioCanonical;
import com.projeto.funancial.model.Usuario;
import com.projeto.funancial.service.UsuarioService;
import com.projeto.funancial.transformation.UsuarioTransformation;
import com.projeto.funancial.util.EncriptadorService;

/**
 * A classe <code>UsuarioController</code> fornece endpoints relacionados ao objeto usuario.
 *
 * @author guilhermeguis@outlook.com
 * @version 1.0
 * @since JDK1.8
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	private UsuarioService service;
	@Autowired
	private EncriptadorService encriptadorService;	
	@Autowired
	private UsuarioTransformation transformation;
	
	public UsuarioController(UsuarioService service) {
		this.service = service;
	}
	
	/**
	 * Retorna todos os usu�rios registrados no banco
	 * 
	 * @return ResponseEntity - Composi��o de lista de usu�rios e o status HTTP 
	 */
	@GetMapping(value = "/")
	public ResponseEntity<List<UsuarioCanonical>> getUsuarios(){
		List<UsuarioCanonical> usuariosCanonical = 
				transformation
				.convert(service
				.findAll()
				.stream()
				.collect(Collectors.toList()));
		if(usuariosCanonical.isEmpty())
			return new ResponseEntity<>(usuariosCanonical, HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(usuariosCanonical, HttpStatus.OK);
	}
	/**
	 * Retorna o usu�rio com o id informado do banco
	 * 
	 * @param ObjectId id - Id do usuario que dever� ser retornado 
	 * @return ResponseEntity - Composi��o de usu�rio buscado e o status HTTP 
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioCanonical> getUsuarioById(@PathVariable("id") ObjectId id) {
		Usuario usuario = service.findBy_Id(id);
		if(usuario == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
		UsuarioCanonical usuarioCanonical = transformation.convert(usuario);
		return new ResponseEntity<>(usuarioCanonical, HttpStatus.OK);
		
	}
	/**
	 * Salva um usu�rio no banco de dados
	 * 
	 * @param UsuarioCanonical usuarioCanonical- Objeto usu�rio informado pelo usu�rio que ser� inserido no reposit�rio
	 * @return ResponseEntity - Composi��o de usu�rio informado e o status HTTP 
	 */
	@PostMapping(value = "/")
	public ResponseEntity<UsuarioCanonical> createUsuario(@RequestBody UsuarioCanonical usuarioCanonical) {
		Usuario usuario = transformation.convert(usuarioCanonical);
		String senhaEncriptada = encriptadorService.getSenhaEncriptada(usuario.getSenha());
		if(senhaEncriptada.equals(usuario.getSenha()))
			return new ResponseEntity<>(usuarioCanonical, 
					HttpStatus.INTERNAL_SERVER_ERROR);
		
		usuario.set_id(ObjectId.get());
		usuario.setSenha(senhaEncriptada);
		service.save(usuario);
		
		return new ResponseEntity<>(transformation.convert(usuario), HttpStatus.CREATED);
	}
	/**
	 * Atualiza o usu�rio com o ID informado no banco de dados
	 * 
	 * @param ObjectId id - Id do usu�rio que sofrer� a altera��o
	 * @param UsuarioCanonical usuarioCanonical - Objeto contendo as altera��es do usu�rio em quest�o 
	 * @return ResponseEntity - Composi��o de usu�rio informado/alterado e o status HTTP 
	 */  
	@PutMapping(value = "/{id}")
	public ResponseEntity<UsuarioCanonical> modifyUsuario(@PathVariable("id") ObjectId id,
			@RequestBody UsuarioCanonical usuarioCanonical) {
		if(getUsuarioById(id) != null) 
			return new ResponseEntity<>(usuarioCanonical, HttpStatus.NOT_FOUND);
		
		Usuario usuario = transformation.convert(usuarioCanonical);
		usuario.set_id(id);
		usuario = service.save(usuario);
		
		return new ResponseEntity<>(transformation.convert(usuario), HttpStatus.OK);
	}
	/**
	 * Remove o usu�rio do banco de dados
	 * 
	 * @param ObjectId id - Id do usu�rio que ser� excluido
	 * @return ResponseEntity - Status HTTP 
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable ObjectId id) {
		try {
			Usuario usuario = transformation.convert(getUsuarioById(id).getBody());
			service.delete(usuario);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
	}
}
