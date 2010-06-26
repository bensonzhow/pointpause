package fr.afcepf.ai77.g1.persitence.tests;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.afcepf.ai77.g1.persistence.dao.ExampleDAO;
import fr.afcepf.ai77.g1.persistence.implementations.DAOImplConfig;
import fr.afcepf.ai77.g1.persistence.interfaces.IExampleDAO;


/*
 * 
 * deuxième façon de configuer ses objets : en utilisant les annotations.
 * En gros, à la place d'un fichier xml + XMLBeanFactory, on configure Spring
 * avec une classe, ici DAOImplConfig. Cet objet s'occupera de la configuration
 * des classes à retourner. 
 * 
 */

public class TestExampleDAO2 {
	private IExampleDAO exampleDAO;

	public IExampleDAO getExampleDAO() {
		return exampleDAO;
	}

	public void setExampleDAO(IExampleDAO exampleDAO) {
		this.exampleDAO = exampleDAO;
	}
	
	public TestExampleDAO2 (){
		AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(DAOImplConfig.class);
		
		setExampleDAO((IExampleDAO)context.getBean("ExampleDAOImpl"));
	}
	
	public static void main(String[] args) {
		TestExampleDAO example = new TestExampleDAO();
		
		ExampleDAO object = example.getExampleDAO().getExampleDAOByNumero(10);
		
		System.out.println("version 2 (avec annotations)");
		System.out.println(object.getNumero());
	}
	
}
