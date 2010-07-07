package fr.afcepf.ai77.g1.metiers.interfaces;

import fr.afcepf.ai77.g1.metiers.dto.BouquetDTO;
import java.util.List;
import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;

public interface IDonneesContratDTO {
	public ContratDTO getContrat(); 
	public Integer insertContrat(ContratDTO contratDTO, BouquetDTO bouquetDTO);
	List<Integer> getListeMachineByContrat(int numContratDTO);
	
	List<ContratDTO> getSyntheseContratbyClient(int numClient);
	List<ContratDTO> getLastContratPourTableau(int numClient);
	
	ContratDTO getContratById(int numContrat);
	Boolean updateContrat(ContratDTO contratdto);
}
