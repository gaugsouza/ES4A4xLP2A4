package com.projeto.funancial.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.projeto.funancial.model.Historia;

/**
 * A interface <code>HistoriaRepository</code> é utilizada para representar as operações CRUD 
 * (Create, Retrieve, Update and Delete) relativas à collection historia da interface 
 * <code>org.springframework.data.mongodb.repository.MongoRepository</code>.
 *
 * @author guilhermeguis@outlook.com
 * @version 1.0
 * @since JDK1.8
 **/

public interface HistoriaRepository extends MongoRepository<Historia, String>{
	Historia findBy_id(ObjectId id);
}
