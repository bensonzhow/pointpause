package fr.afcepf.ai77.g1.metiers.implementations;

import fr.afcepf.ai77.g1.metiers.dto.SessionDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesSessionDTO;
import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesClientDAO;

public class DonneesSessionDTOImpl implements IDonneesSessionDTO {
	
	private IDonneesClientDAO donneesClient = null;
	

	public IDonneesClientDAO getDonneesClient() {
		return donneesClient;
	}


	public void setDonneesClient(IDonneesClientDAO donneesClient) {
		this.donneesClient = donneesClient;
	}


	@Override
	public SessionDTO getSessionDTO(String login, String password) {
		// TODO Auto-generated method stub
		
		Client client = getDonneesClient().getClientBySession(login, password);
		
		if (client==null) return null;
		
		SessionDTO session = new SessionDTO();
		
		session.setLang(client.getLangue());
		session.setLogin(client.getLogin());
		session.setPass(client.getPass());
		session.setNom(client.getNom());
		session.setNumeroClient(client.getNumero());
		
		return session;
	}

}
