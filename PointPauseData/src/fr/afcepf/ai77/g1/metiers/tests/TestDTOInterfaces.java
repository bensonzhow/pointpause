package fr.afcepf.ai77.g1.metiers.tests;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import junit.framework.TestCase;
import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.dto.ExampleDTO;
import fr.afcepf.ai77.g1.metiers.dto.SessionDTO;
import fr.afcepf.ai77.g1.metiers.implementations.ExampleDTOImpl;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesSessionDTO;
import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesClientDAO;

public class TestDTOInterfaces extends TestCase {

	public void testGetSession(){
		
		
		
		IDonneesSessionDTO donneesSession = DTOFactory.getIDonneesSessionDTO();
	
		SessionDTO session = donneesSession.getSessionDTO("rhanouna", "sandrine01");
		
		assertEquals(new Integer(session.getNumeroClient()), new Integer(1));
		
		session = donneesSession.getSessionDTO("rhanouna", "ddd");
		
		assertNull(session);
	}
	
	
}