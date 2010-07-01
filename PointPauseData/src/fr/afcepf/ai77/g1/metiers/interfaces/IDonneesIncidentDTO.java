package fr.afcepf.ai77.g1.metiers.interfaces;

import fr.afcepf.ai77.g1.metiers.dto.IncidentDTO;

public interface IDonneesIncidentDTO {

	IncidentDTO getIncidentDTOByNumero(int numeroContrat);
	Integer insertIncident(IncidentDTO incidentDto);
	
}
