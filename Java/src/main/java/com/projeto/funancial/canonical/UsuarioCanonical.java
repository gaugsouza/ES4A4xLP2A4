package com.projeto.funancial.canonical;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioCanonical { //extends Canonical { 
	/**
	 * 
	 */
	private int id;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
}
