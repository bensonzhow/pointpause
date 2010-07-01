package fr.afcepf.ai77.g1.persistence.createdata;

import org.apache.log4j.BasicConfigurator;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.entity.Employe;
import fr.afcepf.ai77.g1.persistence.entity.SiteClient;
import fr.afcepf.ai77.g1.persistence.implementations.DonneesClientDAOImpl;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesClientDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesEmployeDAO;

public class DataInsertion {

	public static IDonneesClientDAO getDonneesClient() {

		DataInsertion builder = new DataInsertion();

		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"SpringConfig.xml"));

		IDonneesClientDAO donneesClient = (IDonneesClientDAO) factory
				.getBean("IDonneesClientDAO");

		return donneesClient;
	}

	public static IDonneesEmployeDAO getDonneesEmploye() {

		DataInsertion builder = new DataInsertion();

		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"SpringConfig.xml"));

		IDonneesEmployeDAO donneesClient = (IDonneesEmployeDAO) factory
				.getBean("IDonneesEmployeDAO");

		return donneesClient;
	}
	

	public static void main(String[] args) {

		BasicConfigurator.configure();

		IDonneesEmployeDAO donneesEmploye = DataInsertion.getDonneesEmploye();
		IDonneesClientDAO donneesClient = DataInsertion.getDonneesClient();
		
		
		Client bob = new Client( "BobEntreprise", "12355", "Bob",
				"0123456789", "rbob@bobE.com", "rbob", "bobr", "FRA", null);

		Employe marc = new Employe();

	    bob.setEmploye(marc);
		marc.getListeClients().add(bob);
		
		SiteClient site = new SiteClient(bob);
		bob.getListeSitesClients().add(site);
		site = new SiteClient(bob);
		bob.getListeSitesClients().add(site);
		
		
		
		
		
		boolean res =donneesClient.insertClient(bob);

		//boolean res = donneesEmploye.insertEmploye(marc);
		System.out.println(res);

	}

}
