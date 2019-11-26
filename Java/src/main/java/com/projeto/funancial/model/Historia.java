package com.projeto.funancial.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A classe <code>Historia</code> é um POJO (Plain Old Java Object) para representar 
 * a collection funancial.historia do MongoDB.
 *
 * @author guilhermeguis@outlook.com
 * @version 1.0
 * @since JDK1.8
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Historia {
	@Id
	private ObjectId _id;
	private String titulo;
	private List<Opcao> opcoes;
}
