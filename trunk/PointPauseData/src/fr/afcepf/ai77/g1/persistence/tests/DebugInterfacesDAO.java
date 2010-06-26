package fr.afcepf.ai77.g1.persistence.tests;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.afcepf.ai77.g1.persistence.dao.ClientDAO;
import fr.afcepf.ai77.g1.persistence.implementations.DAOImplConfig;
import fr.afcepf.ai77.g1.persistence.implementations.IDonneesClientDAOImpl;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesClientDAO;

//sert juste � debugger, le code n'a aucune importance
public class DebugInterfacesDAO {

	public static void main(String[] args) {

	/*	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DAOImplConfig.class);

		IDonneesClientDAO donneesClient = (IDonneesClientDAO) context
				.getBean("accessDonneesClient");*/
		
		IDonneesClientDAO donneesClient = new IDonneesClientDAOImpl();

		ClientDAO client = donneesClient.getClientByNumero(1);

		if (client == null) {
			System.out.println("pas de client");
		} 
		else
			System.out.println(client.toString());

	}

}
