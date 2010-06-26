package fr.afcepf.ai77.g1.persistence.tests;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.afcepf.ai77.g1.persistence.dao.ClientDAO;
import fr.afcepf.ai77.g1.persistence.implementations.DAOImplConfig;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesClientDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IExampleDAO;
import junit.framework.TestCase;

public class TestDAOInterfaces extends TestCase {
	 
	public  void testGetClientDAOByNumero() throws Exception {

		AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(
				DAOImplConfig.class);
		
		IDonneesClientDAO donneesClient = (IDonneesClientDAO)context.getBean("accessDonneesClient");

		
		
		ClientDAO client = donneesClient.getClientByNumero(1);
		
		
		assertEquals(client.getNumero(), new Integer(1));
		assertTrue(client.getNom().contains("COGIP"));
		
		

	}

}
