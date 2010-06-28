package fr.afcepf.ai77.g1.persistence.tests;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import fr.afcepf.ai77.g1.persistence.dao.ExampleDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IExampleDAO;

/*
 * Première façon de configurer spring, utiliser un fichier xml qui sera 
 * lu avec un XMLBeanFactory. Il y trouvera des infos pour initialiser la classe
 * en question. 
 */


public class TestExampleDAO {

	private IExampleDAO exampleDAO;

	
	public IExampleDAO getExampleDAO() {
		return exampleDAO;
	}

	
	public void setExampleDAO(IExampleDAO exampleDAO) {
		this.exampleDAO = exampleDAO;
	}
	
	
	public TestExampleDAO (){
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
		"SpringConfig.xml"));
		
		setExampleDAO((IExampleDAO)factory.getBean("SpringConfig.xml"));
	}
	
	
	public static void main(String[] args) {
		TestExampleDAO example = new TestExampleDAO();
		
		ExampleDAO object = example.getExampleDAO().getExampleDAOByNumero(10);
		
		System.out.println("Première version (configuration par xml)");
		System.out.println(object.getNumero());
	}
	
}
