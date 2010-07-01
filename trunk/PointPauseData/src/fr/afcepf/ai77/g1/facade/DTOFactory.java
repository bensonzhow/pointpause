package fr.afcepf.ai77.g1.facade;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesContratDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesIncidentDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesSessionDTO;

public class DTOFactory {
	static XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("SpringConfig.xml"));
	
	
	public static IDonneesSessionDTO getIDonneesSessionDTO(){
		IDonneesSessionDTO sessionProvider = (IDonneesSessionDTO) factory.getBean("IDonneesSessionDTO");
		return sessionProvider;
	}
	
	public static IDonneesContratDTO getIDonneesContratDTO(){
		IDonneesContratDTO donneesContrat = (IDonneesContratDTO) factory.getBean("IDonneesContratDTO");
		return donneesContrat;
	}

	public static IDonneesIncidentDTO getIDonneesIncidentDTO(){
		IDonneesIncidentDTO donneesIncident = (IDonneesIncidentDTO) factory.getBean("IDonneesIncidentDTO");
		return donneesIncident;
	}
	
}
