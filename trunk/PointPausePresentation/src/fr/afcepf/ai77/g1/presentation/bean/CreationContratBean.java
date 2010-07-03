package fr.afcepf.ai77.g1.presentation.bean;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesContratDTO;
import fr.afcepf.ai77.g1.persistence.entity.Formule;



public class CreationContratBean {

	
	   private ArrayList<String> liste = new ArrayList<String>();
	   
	public ArrayList<String> getListe() {
		liste.add("lala");
		liste.add("lolo");
		return liste;
	}

	public void setListe(ArrayList<String> pListe) {
		liste = pListe;
	}

	
	
   
   
}
