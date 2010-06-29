package fr.afcepf.ai77.g1.persistence.tests;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.implementations.DAOImplConfig;
import fr.afcepf.ai77.g1.persistence.implementations.DonneesClientDAOImpl;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesClientDAO;

//sert juste à debugger, le code n'a aucune importance
public class DebugInterfacesDAO {

	public static void main(String[] args) {

	/*	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DAOImplConfig.class);

		IDonneesClientDAO donneesClient = (IDonneesClientDAO) context
				.getBean("accessDonneesClient");*/
		
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
		"SpringConfig.xml"));
		
		IDonneesClientDAO donneesClient = (IDonneesClientDAO)factory.getBean("IDonneesClientDAO");
		
		Client client = donneesClient.getClientBySession("rhanouna", "sandrine01");
		
		if (client==null) System.out.println("fail");
		
		System.out.println(client.getLangue());
/*
		if (client == null) {
			System.out.println("pas de client");
		} 
		else
			System.out.println(client.toString());*/

	}

}
