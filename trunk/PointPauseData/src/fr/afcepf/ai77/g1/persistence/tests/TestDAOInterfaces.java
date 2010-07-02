package fr.afcepf.ai77.g1.persistence.tests;

import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.entity.Formule;
import fr.afcepf.ai77.g1.persistence.entity.TypePb;
import fr.afcepf.ai77.g1.persistence.implementations.DAOImplConfig;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesClientDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesContratDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesTypePbDAO;
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
	
	public void testGetClientDAOByLogin(){
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
		"SpringConfig.xml"));
		
		IDonneesClientDAO donneesClient = (IDonneesClientDAO)factory.getBean("IDonneesClientDAO");
	
		Client client = donneesClient.getClientBySession("rhanouna", "sandrine01");

	
		assertEquals(client.getNumero(), new Integer(1));
		
		
		client = donneesClient.getClientBySession("rhanouna", "sandfddfdfrine01");

		
		assertNull(client);
		
	}
	
	public void testGetAllFormules(){
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
		"SpringConfig.xml"));
		IDonneesContratDAO donneesContrat = (IDonneesContratDAO)factory.getBean("IDonneesContratDAO");
		List<Formule> lf = donneesContrat.getAllFormule();
		System.out.println(lf.get(0).getLibelleFormule());
		assertEquals("fraicheur",lf.get(0).getLibelleFormule())	;
	}
	
	public void testGetType(){
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
		"SpringConfig.xml"));
		IDonneesTypePbDAO donneesTypePb = (IDonneesTypePbDAO)factory.getBean("IDonneesTypePbDAO");	
		
		TypePb tpb = donneesTypePb.getTypePbByNumero(2);
		
		assertTrue(tpb.getLibelle().contains("dysfonctionnement")); 
		
	}

}