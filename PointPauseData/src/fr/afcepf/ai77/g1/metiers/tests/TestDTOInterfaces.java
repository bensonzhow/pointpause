package fr.afcepf.ai77.g1.metiers.tests;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import junit.framework.TestCase;
import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;
import fr.afcepf.ai77.g1.metiers.dto.ExampleDTO;
import fr.afcepf.ai77.g1.metiers.dto.IncidentDTO;
import fr.afcepf.ai77.g1.metiers.dto.InterventionDTO;
import fr.afcepf.ai77.g1.metiers.dto.SessionDTO;
import fr.afcepf.ai77.g1.metiers.dto.StatutIncidentDTO;
import fr.afcepf.ai77.g1.metiers.implementations.ExampleDTOImpl;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesContratDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesIncidentDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesSessionDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesChoixContratDTO;
import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.entity.Formule;



public class TestDTOInterfaces extends TestCase {

	public void testGetSession(){
		
		
		
		IDonneesSessionDTO donneesSession = DTOFactory.getIDonneesSessionDTO();
	
		SessionDTO session = donneesSession.getSessionDTO("rhanouna", "sandrine01");
		
		
		assertNotNull(session);
		//assertEquals(new Integer(session.getNumeroClient()), new Integer(1));
		
		session = donneesSession.getSessionDTO("rhanouna", "ddd");
		
		assertNull(session);
	}
	
	public void testGetContrat(){
		
	}
	
	public void testInsertIncident(){
		IDonneesIncidentDTO donneesIncident = DTOFactory.getIDonneesIncidentDTO();
		
		IncidentDTO iDTO = new IncidentDTO();
		
		iDTO.setNumClient(1);
		iDTO.setDateConstatIncident(new Date());
		iDTO.setDateDeclarationIncident(new Date());
		iDTO.setFlag(true);
		
		Integer res = donneesIncident.insertIncident(iDTO);
		
		assertNotNull(res);
		
		assertEquals(res, new Integer(0));
		
	}

	//on teste si on peut avoir toutes les infos, automates, formules dispo...
	//pourl'instant que formules
	public void testGetChoixContrat(){
		IDonneesChoixContratDTO donneesChoixContrat = DTOFactory.getIDonneesChoixContratDTO();
		List<Formule> lf = donneesChoixContrat.getAllGeneral();
		assertEquals("fraicheur", lf.get(0).getLibelleFormule());
	}
	
	
	public void testGetIncidentByClient(){
		IDonneesIncidentDTO donneesIncident = DTOFactory.getIDonneesIncidentDTO();
		
		List<IncidentDTO> liste = donneesIncident.getHistoriqueIncidentByClient(2);
		
		for (IncidentDTO incident : liste){
			System.out.println("Incident n° "+incident.getNumero()+", installation n°"+incident.getNumInstallation());
			System.out.println("\t client : "+incident.getNumClient());
			System.out.println("\t numero contrat : "+incident.getNumContrat());
			System.out.println("\t date declaration : "+incident.getDateDeclarationIncident());
			System.out.println("\t date constat : "+incident.getDateDeclarationIncident());
			
			for (StatutIncidentDTO statutincident : incident.getHistorique()){
				System.out.println("\t\t date : "+statutincident.getDateNouveauStatut());
				System.out.println("\t\t commentaire : "+statutincident.getCommentaire());
				if (statutincident.getIntervention()!=null){
					InterventionDTO interv = statutincident.getIntervention();
					System.out.println("\t\t\t intervention employe : "+interv.getNomEmploye());
					System.out.println("\t\t\t intervention commentaire "+interv.getCommentaire());
				}
				
			}
			
		}
	
	}
	
}
