package com.projeto.funancial.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.projeto.funancial.model.Opcao;

/**
 * A interface <code>OpcaoRepository</code> � utilizada para representar as opera��es CRUD 
 * (Create, Retrieve, Update and Delete) relativas � collection opcao da interface 
 * <code>org.springframework.data.mongodb.repository.MongoRepository</code>.
 *
 * @author guilhermeguis@outlook.com
 * @version 1.0
 * @since JDK1.8
 **/

public interface OpcaoRepository extends MongoRepository<Opcao, String>{
	Opcao findBy_id(ObjectId id);
}
