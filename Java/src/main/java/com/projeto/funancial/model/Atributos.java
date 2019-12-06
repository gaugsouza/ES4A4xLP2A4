package com.projeto.funancial.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A classe <code>Atributo</code> é um POJO (Plain Old Java Object) para representar 
 * a collection funancial.atributo do MongoDB.
 *
 * @author guilhermeguis@outlook.com
 * @version 1.0
 * @since JDK1.8
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Atributo {
	@Id
	private ObjectId _id;
	private String nome;
	private Integer quantidade;
}
