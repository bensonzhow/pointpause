package fr.afcepf.ai77.g1.persistence.tests;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.entity.Contrat;
import fr.afcepf.ai77.g1.persistence.entity.Formule;
import fr.afcepf.ai77.g1.persistence.entity.Incident;
import fr.afcepf.ai77.g1.persistence.entity.Installation;
import fr.afcepf.ai77.g1.persistence.entity.ModeleAutomate;
import fr.afcepf.ai77.g1.persistence.entity.TypePb;
import fr.afcepf.ai77.g1.persistence.implementations.DAOImplConfig;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesChoixContratDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesClientDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesContratDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesIncidentDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesTypePbDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IExampleDAO;
import junit.framework.TestCase;

public class TestDAOInterfaces extends TestCase {

	public void testGetClientDAOByNumero() throws Exception {

		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"SpringConfig.xml"));

		IDonneesClientDAO donneesClient = (IDonneesClientDAO) factory
				.getBean("IDonneesClientDAO");

		Client client = donneesClient.getClientByNumero(1);

		assertEquals(client.getNumero(), new Integer(1));
		assertTrue(client.getNom().contains("COGIP"));

	}
	// pr tableau de bord récupérer les derniers contrats
	public void testGetLastContrat(){
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
		"SpringConfig.xml"));
		IDonneesContratDAO donneesContrat = (IDonneesContratDAO) factory.getBean("IDonneesContratDAO");
		List<Contrat> lastContrats = donneesContrat.getLastContratsBouquetInstallByClient(4);
		System.out.println(lastContrats);
	}

	public void testGetClientDAOByLogin() {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"SpringConfig.xml"));

		IDonneesClientDAO donneesClient = (IDonneesClientDAO) factory
				.getBean("IDonneesClientDAO");

		Client client = donneesClient.getClientBySession("rhanouna",
				"sandrine01");

		assertEquals(client.getNumero(), new Integer(1));

		client = donneesClient.getClientBySession("rhanouna",
				"sandfddfdfrine01");

		assertNull(client);

	}

	public void testGetAllFormules() {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"SpringConfig.xml"));
		IDonneesChoixContratDAO donneesContrat = (IDonneesChoixContratDAO) factory
				.getBean("IDonneesChoixContratDAO");
		List<Formule> lf = donneesContrat.getAllGeneralFormules();
		System.out.println(lf.get(0).getLibelleFormule());
		assertEquals("fraicheur", lf.get(0).getLibelleFormule());
	}

	public void testGetAllMachines() {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"SpringConfig.xml"));
		IDonneesChoixContratDAO donneesContrat = (IDonneesChoixContratDAO) factory
				.getBean("IDonneesChoixContratDAO");
		List<ModeleAutomate> lf = donneesContrat.getAllAutomates();
		System.out.println(lf.get(0).getNom());
		assertEquals("Expresso", lf.get(0).getNom());
	}

	public void testGetType() {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"SpringConfig.xml"));
		IDonneesTypePbDAO donneesTypePb = (IDonneesTypePbDAO) factory
				.getBean("IDonneesTypePbDAO");

		TypePb tpb = donneesTypePb.getTypePbByNumero(2);

		assertTrue(tpb.getLibelle().contains("dysfonctionnement"));

	}

	public void testGetContratByClient() {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"SpringConfig.xml"));
		IDonneesClientDAO donneesClient = (IDonneesClientDAO) factory
				.getBean("IDonneesClientDAO");
		List<Contrat> listeContrat = (List<Contrat>) donneesClient
				.getNumContratbyNumClient(19);
		assertTrue(listeContrat != null);
		assertTrue(listeContrat.get(0).getNumero() == 5);
	}

	public void testGetInstallationByClient() {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"SpringConfig.xml"));
		IDonneesClientDAO donneesClient = (IDonneesClientDAO) factory
				.getBean("IDonneesClientDAO");
		
		List<Installation> listInstall= donneesClient.getInstallationByNumClient(20);
		
		assertEquals(listInstall.size(), 15);
		
		for (Installation inst : listInstall){
			assertTrue(inst.getNumero()>44);
			assertTrue(inst.getNumero()<60);
		}
		
	}
	
	public void testGetAllContratsAndStuffsByClient(){
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
		"SpringConfig.xml"));
		IDonneesContratDAO donneesContrat = (IDonneesContratDAO) factory
		.getBean("IDonneesContratDAO");

		List<Contrat> liste = donneesContrat.getAllContratBouquetInstallByClient(2);
		
		
	}
	
	public void testInsertIncident2(){
		
		Incident incident = new Incident();
		incident.setDateDeclarationIncident(new Date());
		incident.setFlag(false);
		
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
		"SpringConfig.xml"));
		IDonneesIncidentDAO donneesIncident = (IDonneesIncidentDAO) factory
		.getBean("IDonneesIncidentDAO");		
		
		donneesIncident.insertIncident(incident);
		
		
		
	}

	
	public void testGetTypePb(){
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
		"SpringConfig.xml"));
		IDonneesTypePbDAO donneesTypePb = (IDonneesTypePbDAO) factory
		.getBean("IDonneesTypePbDAO");
		
		List<String> listeLibelles = donneesTypePb.getTypePb();
		
		
		//assertTrue(listeLibelles.size()==7);
		
		for (String s : listeLibelles) System.out.println(s);
	}
	
	public void testGetLastIncidents(){
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
		"SpringConfig.xml"));
		IDonneesIncidentDAO donneesInc = (IDonneesIncidentDAO) factory
		.getBean("IDonneesIncidentDAO");
		
		List<Incident> liste = donneesInc.getLastIncidentByClient(4);
		
		assertTrue(liste.size()>0);
				
	}
	
}