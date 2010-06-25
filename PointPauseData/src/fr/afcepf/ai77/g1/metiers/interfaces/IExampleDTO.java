package fr.afcepf.ai77.g1.metiers.interfaces;

import java.util.List;

import fr.afcepf.ai77.g1.metiers.dto.ExampleDTO;



public interface IExampleDTO {
	
	//get
	ExampleDTO getExampleDTOByNumero(int numero_dto);
		
	//update
	boolean updateExampleDTO(ExampleDTO dto);
	
	//create
	boolean createExampleDTO(ExampleDTO dto);
	
	//normalement on remove jamais mais bon
	boolean removeExampleDTO(ExampleDTO dto);
	
	//on peut rajouter des fonctions en fonction des use case. Par exemple :
	
	List<ExampleDTO> getAllExampleDTOFromContrat(int numero_contrat);
	
	List<ExampleDTO> getAllExampleDTOWhereValeurContratSuperieurA(float valeur_minimum_contrat);

	List<ExampleDTO> getExampleDTOByClient(int numero_client);
	
	//etc
}
