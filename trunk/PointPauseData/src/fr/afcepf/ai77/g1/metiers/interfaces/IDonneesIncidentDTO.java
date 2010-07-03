package fr.afcepf.ai77.g1.metiers.interfaces;

import java.util.List;

import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;
import fr.afcepf.ai77.g1.metiers.dto.IncidentDTO;
import fr.afcepf.ai77.g1.metiers.dto.ListeContratDTO;

public interface IDonneesIncidentDTO {

	IncidentDTO getIncidentDTOByNumero(int numeroContrat);
	Integer insertIncident(IncidentDTO incidentDto);
	ListeContratDTO getContratsByNumClient(int numClient);
	
}
