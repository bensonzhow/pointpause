package fr.afcepf.ai77.g1.persistence.interfaces;

import java.util.List;

import fr.afcepf.ai77.g1.persistence.entity.Example;

/*
 * cette interface définit au moins le CRUD sur le truc qui nous intéresse
 * 
 * 
 * */
public interface IExampleDAO {
	
	//get
	Example getExampleDAOByNumero(int numero_DAO);
		
	//update
	boolean updateExampleDAO(Example DAO);
	
	//create
	boolean createExampleDAO(Example DAO);
	
	//normalement on remove jamais mais bon
	boolean removeExampleDAO(Example DAO);
	
	//on peut rajouter des fonctions en fonction des use case. Par exemple :
	
	List<Example> getAllExampleDAOFromContrat(int numero_contrat);
	
	List<Example> getAllExampleDAOWhereValeurContratSuperieurA(float valeur_minimum_contrat);

	List<Example> getExampleDAOByClient(int numero_client);
	
	//etc
}
