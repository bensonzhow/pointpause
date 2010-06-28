package fr.afcepf.ai77.g1.metiers.interfaces;

import fr.afcepf.ai77.g1.metiers.dto.SessionDTO;

public interface IDonneesSessionDTO {

	/*retourne un SessionDTO si ok, null si pas ok*/
	SessionDTO getSessionDTO(String login, String password);
	
}
