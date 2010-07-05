package fr.afcepf.ai77.g1.metiers.interfaces;

import java.util.List;

import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;

public interface IDonneesContratDTO {
	public ContratDTO getContrat(); 
	public Integer insertContrat(ContratDTO contratDTO);
	List<Integer> getListeMachineByContrat(int numContratDTO);
}
