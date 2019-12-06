package com.projeto.funancial.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.projeto.funancial.model.Historia;
import com.projeto.funancial.repository.HistoriaRepository;

/**
 * A classe <code>HistoriaService</code> � respons�vel por manipular as opera��es CRUD 
 * (Create, Retrieve, Update and Delete) relativas ao reposit�rio <code>HistoriaRepository</code>
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
     * Encontra todas as hist�rias da collection no banco.
     *
     * @return List<Historia> - Todos as hist�rias encontrados.
     */
    public List<Historia> findAll(){
    	List<Historia> historias = new ArrayList<>();
        this.historiaRepository.findAll().forEach(historias :: add);
        
        return historias;
    }
    
    /**
     * Encontra uma hist�ria por seu Id.
     *
     * @param ObjectId _id - A identifica��o da hist�ria
     * @return Historia - A hist�ria, se existir
     */
    public Historia findBy_Id(ObjectId id) {
    	return historiaRepository.findBy_id(id);
    }
    
    /**
     * Salva uma hist�ria no banco de dados
     *
     * @param Historia historia - A hist�ria que ser� salva no banco de dados
     * @return Historia - A hist�ria salva.
     */
    public Historia save(Historia historia) {   	
    	return historiaRepository.save(historia);
    }

}
