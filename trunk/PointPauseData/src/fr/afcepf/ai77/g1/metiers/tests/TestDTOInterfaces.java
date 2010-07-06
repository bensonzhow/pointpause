package fr.afcepf.ai77.g1.metiers.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate3.HibernateTemplate;

import junit.framework.TestCase;
import fr.afcepf.ai77.g1.facade.DTOFactory;
import fr.afcepf.ai77.g1.metiers.dto.BouquetDTO;
import fr.afcepf.ai77.g1.metiers.dto.ContratDTO;
import fr.afcepf.ai77.g1.metiers.dto.ExampleDTO;
import fr.afcepf.ai77.g1.metiers.dto.IncidentDTO;
import fr.afcepf.ai77.g1.metiers.dto.InterventionDTO;
import fr.afcepf.ai77.g1.metiers.dto.SessionDTO;
import fr.afcepf.ai77.g1.metiers.dto.StatutIncidentDTO;
import fr.afcepf.ai77.g1.metiers.implementations.ExampleDTOImpl;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesContratDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesIncidentDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesSessionDTO;
import fr.afcepf.ai77.g1.metiers.interfaces.IDonneesChoixContratDTO;
import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.entity.Formule;



public class TestDTOInterfaces extends TestCase {

	public void testGetSession(){
		
		
		
		IDonneesSessionDTO donneesSession = DTOFactory.getIDonneesSessionDTO();
	
		SessionDTO session = donneesSession.getSessionDTO("rhanouna", "sandrine01");
		
		
		assertNotNull(session);
		//assertEquals(new Integer(session.getNumeroClient()), new Integer(1));
		
		session = donneesSession.getSessionDTO("rhanouna", "ddd");
		
		assertNull(session);
	}
	
	public void testGetContrat(){
		
	}
	
	public void testInsertIncident(){
		IDonneesIncidentDTO donneesIncident = DTOFactory.getIDonneesIncidentDTO();
		
		IncidentDTO iDTO = new IncidentDTO();
		
		iDTO.setNumClient(1);
		iDTO.setDateConstatIncident(new Date());
		iDTO.setDateDeclarationIncident(new Date());
		iDTO.setFlag(true);
		
		Integer res = donneesIncident.insertIncident(iDTO);
		
		assertNotNull(res);
		
		assertEquals(res, new Integer(0));
		
	}

	//on teste si on peut avoir toutes les infos, automates, formules dispo...
	//pourl'instant que formules
	public void testGetChoixContrat(){
		IDonneesChoixContratDTO donneesChoixContrat = DTOFactory.getIDonneesChoixContratDTO();
		List<Formule> lf = donneesChoixContrat.getAllGeneral();
		assertEquals("fraicheur", lf.get(0).getLibelleFormule());
	}
	
	
	public void testGetIncidentByClient(){
		IDonneesIncidentDTO donneesIncident = DTOFactory.getIDonneesIncidentDTO();
		
		List<IncidentDTO> liste = donneesIncident.getHistoriqueIncidentByClient(19);
		
		for (IncidentDTO incident : liste){
			System.out.println("Incident n° "+incident.getNumero()+", installation n°"+incident.getNumInstallation());
			System.out.println("\t client : "+incident.getNumClient());
			System.out.println("\t numero contrat : "+incident.getNumContrat());
			System.out.println("\t date declaration : "+incident.getDateDeclarationIncident());
			System.out.println("\t date constat : "+incident.getDateDeclarationIncident());
			
			for (StatutIncidentDTO statutincident : incident.getHistorique()){
				System.out.println("\t\t date : "+statutincident.getDateNouveauStatut());
				System.out.println("\t\t commentaire : "+statutincident.getCommentaire());
				if (statutincident.getIntervention()!=null){
					InterventionDTO interv = statutincident.getIntervention();
					System.out.println("\t\t\t intervention employe : "+interv.getNomEmploye());
					System.out.println("\t\t\t intervention commentaire "+interv.getCommentaire());
				}
				
			}
			
		}
	
	}
	
	public void testInsertContrat(){
		IDonneesContratDTO donnees = DTOFactory.getIDonneesContratDTO();
		ContratDTO contratDTO = new ContratDTO();
		BouquetDTO bouquetDTO = new BouquetDTO();
		bouquetDTO.setCodeFormule(2);
		bouquetDTO.setQuantite(150);
		bouquetDTO.setCodemodeleAutomate(4);
		
		contratDTO.setCommentaire("je suis un contrat DTO de test");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = "19/01/1998";
		Date debut = new Date();
		try {
			debut = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dateFin = "25/05/2001";
		Date fin = new Date();
		try {
			fin = sdf.parse(dateFin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		contratDTO.setDateDebut(debut);
		contratDTO.setDateFin(fin);
		contratDTO.setFlag(false);
		contratDTO.setFreqApprovisionnement(5);
		contratDTO.setGarantie(false);
		Calendar cal = Calendar.getInstance();
		cal.setTime(debut);
		int d1 = cal.get(Calendar.DATE);
		cal.setTime(fin);
		int d2 = cal.get(Calendar.DATE);
		int duree= d2 - d1;
		contratDTO.setDuree(duree);
		contratDTO.setNumClient(2);
		System.out.println(donnees.insertContrat(contratDTO, bouquetDTO));
	//marche au 04/07/2010 chez anna	
	}
	
	
	
	public void testGetAllContratAndStuffsByClient(){
		
		IDonneesContratDTO donneesContrat = DTOFactory.getIDonneesContratDTO();
		
		List<ContratDTO> liste = donneesContrat.getSyntheseContratbyClient(2);
		
		assertNotNull(liste);
		
		System.out.println(liste.size());
		
		for (ContratDTO c : liste){
			System.out.println(c.toString());
			for (BouquetDTO b : c.getListeBouquets()){
				System.out.println("\t"+b.toString());
			}
		}
		
	}
	
	public void testSwitchIncidentFlag(){
		IDonneesIncidentDTO donneesIncident = DTOFactory.getIDonneesIncidentDTO();
		boolean res = donneesIncident.switchIncidentFlag(1);
		assertTrue(res);
	}
	
}
