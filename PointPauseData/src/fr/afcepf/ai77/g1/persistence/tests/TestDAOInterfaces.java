package fr.afcepf.ai77.g1.persistence.tests;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.implementations.DAOImplConfig;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesClientDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IExampleDAO;
import junit.framework.TestCase;

public class TestDAOInterfaces extends TestCase {
	 
	public  void testGetClientDAOByNumero() throws Exception {

		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
		"SpringConfig.xml"));
		
		IDonneesClientDAO donneesClient = (IDonneesClientDAO)factory.getBean("IDonneesClientDAO");
	
		Client client = donneesClient.getClientByNumero(1);

		assertEquals(client.getNumero(), new Integer(1));
		assertTrue(client.getNom().contains("COGIP"));
		
		

	}

}