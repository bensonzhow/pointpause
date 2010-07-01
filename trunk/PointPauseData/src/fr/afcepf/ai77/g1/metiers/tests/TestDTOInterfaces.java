package fr.afcepf.ai77.g1.metiers.tests;

import java.util.Date;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import junit.framework.TestCase;
import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;
import fr.afcepf.ai77.g1.metiers.dto.ExampleDTO;
import fr.afcepf.ai77.g1.metiers.dto.IncidentDTO;
import fr.afcepf.ai77.g1.metiers.dto.SessionDTO;
import fr.afcepf.ai77.g1.metiers.implementations.ExampleDTOImpl;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesContratDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesIncidentDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesSessionDTO;
import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesClientDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesContratDAO;

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
		IDonneesContratDTO donneesContrat = DTOFactory.getIDonneesContratDTO(); 
		ContratDTO contratDTO = donneesContrat.getContrat();
		assertEquals(contratDTO.getFormule().get(0).getLibelleFormule(), "fraicheur");
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
	
}
