package fr.afcepf.ai77.g1.persistence.implementations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesClientDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IExampleDAO;


@Configuration
public class DAOImplConfig {
	
	public @Bean IExampleDAO ExampleDAOImpl(){
		return new IExampleDAOImpl();
	}
	
	public @Bean IDonneesClientDAO accessDonneesClient(){
		return new IDonneesClientDAOImpl();
	}
	
}
