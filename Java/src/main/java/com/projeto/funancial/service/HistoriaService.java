package com.projeto.funancial.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.projeto.funancial.model.Historia;
import com.projeto.funancial.repository.HistoriaRepository;

/**
 * A classe <code>HistoriaService</code> é responsável por manipular as operações CRUD 
 * (Create, Retrieve, Update and Delete) relativas ao repositório <code>HistoriaRepository</code>
 *
 * @author guilhermeguis@outlook.com
 * @version 1.0
 * @since JDK1.8
 */
public class HistoriaService {
	private HistoriaRepository historiaRepository;
	
    public HistoriaService(HistoriaRepository historiaRepository) {
    	this.historiaRepository = historiaRepository;
    }
    
    /**
     * Encontra todas as histórias da collection no banco.
     *
     * @return List<Historia> - Todos as histórias encontrados.
     */
    public List<Historia> findAll(){
    	List<Historia> historias = new ArrayList<>();
        this.historiaRepository.findAll().forEach(historias :: add);
        
        return historias;
    }
    
    /**
     * Encontra uma história por seu Id.
     *
     * @param ObjectId _id - A identificação da história
     * @return Historia - A história, se existir
     */
    public Historia findBy_Id(ObjectId id) {
    	return historiaRepository.findBy_id(id);
    }
    
    /**
     * Salva uma história no banco de dados
     *
     * @param Historia historia - A história que será salva no banco de dados
     * @return Historia - A história salva.
     */
    public Historia save(Historia historia) {   	
    	return historiaRepository.save(historia);
    }

}
