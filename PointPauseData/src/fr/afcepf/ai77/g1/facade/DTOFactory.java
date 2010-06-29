package fr.afcepf.ai77.g1.facade;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesSessionDTO;

public class DTOFactory {

	public static IDonneesSessionDTO getIDonneesSessionDTO(){
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("SpringConfig.xml"));
		
		IDonneesSessionDTO sessionProvider = (IDonneesSessionDTO) factory.getBean("IDonneesSessionDTO");
		
		return sessionProvider;
	}
	
	private DTOFactory(){
		
	}
}
