package fr.afcepf.ai77.g1.persistence.interfaces;

import java.util.List;

import fr.afcepf.ai77.g1.persistence.dao.ExampleDAO;

/*
 * cette interface définit au moins le CRUD sur le truc qui nous intéresse
 * 
 * 
 * */
public interface IExampleDAO {
	
	//get
	ExampleDAO getExampleDAOByNumero(int numero_DAO);
		
	//update
	boolean updateExampleDAO(ExampleDAO DAO);
	
	//create
	boolean createExampleDAO(ExampleDAO DAO);
	
	//normalement on remove jamais mais bon
	boolean removeExampleDAO(ExampleDAO DAO);
	
	//on peut rajouter des fonctions en fonction des use case. Par exemple :
	
	List<ExampleDAO> getAllExampleDAOFromContrat(int numero_contrat);
	
	List<ExampleDAO> getAllExampleDAOWhereValeurContratSuperieurA(float valeur_minimum_contrat);

	List<ExampleDAO> getExampleDAOByClient(int numero_client);
	
	//etc
}
