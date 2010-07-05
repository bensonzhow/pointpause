package fr.afcepf.ai77.g1.persistence.interfaces;

import java.util.List;

import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;
import fr.afcepf.ai77.g1.persistence.entity.Bouquet;
import fr.afcepf.ai77.g1.persistence.entity.Contrat;
import fr.afcepf.ai77.g1.persistence.entity.Formule;
import fr.afcepf.ai77.g1.persistence.entity.LoadingPolicy;

public interface IDonneesContratDAO {
	List<Formule> getAllFormule();


	
	Contrat getContratById(Integer id);
	//non lazy version
	Contrat getContratById(Integer id, LoadingPolicy policies);
	
	//update
	boolean updateContrat(Contrat contrat);
	
	Contrat getContratByNumInstallation(int numInstallation);
	

	List<Contrat> getListContratFromListNumInstallation(List<Integer> listInstalls);
	

	Integer insertContrat(Contrat contrat);
	
	List<Integer> listeNumMachineByNumContrat(int numContrat);
}
