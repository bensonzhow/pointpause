package fr.afcepf.ai77.g1.persistence.createdata;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import fr.afcepf.ai77.g1.persistence.entity.Bouquet;
import fr.afcepf.ai77.g1.persistence.entity.Client;
import fr.afcepf.ai77.g1.persistence.entity.Contrat;
import fr.afcepf.ai77.g1.persistence.entity.Employe;
import fr.afcepf.ai77.g1.persistence.entity.Incident;
import fr.afcepf.ai77.g1.persistence.entity.Installation;
import fr.afcepf.ai77.g1.persistence.entity.Intervention;
import fr.afcepf.ai77.g1.persistence.entity.LoadingPolicy;
import fr.afcepf.ai77.g1.persistence.entity.SiteClient;
import fr.afcepf.ai77.g1.persistence.entity.StatutIncident;
import fr.afcepf.ai77.g1.persistence.entity.TypePb;
import fr.afcepf.ai77.g1.persistence.entity.TypeStatutIncident;
import fr.afcepf.ai77.g1.persistence.implementations.DonneesClientDAOImpl;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesBouquetDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesClientDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesContratDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesEmployeDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesIncidentDAO;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesInstallationDAO;

public class DataInsertion {

	public static IDonneesClientDAO getDonneesClient() {

		DataInsertion builder = new DataInsertion();

		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"SpringConfig.xml"));

		IDonneesClientDAO donneesClient = (IDonneesClientDAO) factory
				.getBean("IDonneesClientDAO");

		return donneesClient;
	}

	public static IDonneesBouquetDAO getDonneesBouquet() {

		DataInsertion builder = new DataInsertion();

		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"SpringConfig.xml"));

		IDonneesBouquetDAO donneesBouquet = (IDonneesBouquetDAO) factory
				.getBean("IDonneesBouquetDAO");

		return donneesBouquet;
	}

	public static IDonneesContratDAO getDonneesContrat() {

		DataInsertion builder = new DataInsertion();

		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"SpringConfig.xml"));

		IDonneesContratDAO donneesContrat = (IDonneesContratDAO) factory
				.getBean("IDonneesContratDAO");

		return donneesContrat;
	}

	public static IDonneesIncidentDAO getDonneesIncident() {

		DataInsertion builder = new DataInsertion();

		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"SpringConfig.xml"));

		IDonneesIncidentDAO donneesIncident = (IDonneesIncidentDAO) factory
				.getBean("IDonneesIncidentDAO");

		return donneesIncident;
	}

	public static IDonneesInstallationDAO getDonneesInstallation() {

		DataInsertion builder = new DataInsertion();

		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"SpringConfig.xml"));

		IDonneesInstallationDAO donneesInstallation = (IDonneesInstallationDAO) factory
				.getBean("IDonneesInstallationDAO");

		return donneesInstallation;
	}

	public static IDonneesEmployeDAO getDonneesEmploye() {

		DataInsertion builder = new DataInsertion();

		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"SpringConfig.xml"));

		IDonneesEmployeDAO donneesClient = (IDonneesEmployeDAO) factory
				.getBean("IDonneesEmployeDAO");

		return donneesClient;
	}

	public static void insertBasicData() {
		IDonneesEmployeDAO donneesEmploye = DataInsertion.getDonneesEmploye();
		IDonneesClientDAO donneesClient = DataInsertion.getDonneesClient();

		Client bob = new Client("BobEntreprise", "12355", "Bob", "0123456789",
				"rbob@bobE.com", "rbob", "bobr", "FRA", null);

		Employe marc = new Employe();

		bob.setEmploye(marc);
		marc.getListeClients().add(bob);

		SiteClient site = new SiteClient(bob);
		bob.getListeSitesClients().add(site);
		site = new SiteClient(bob);
		bob.getListeSitesClients().add(site);

		boolean res = donneesClient.insertClient(bob);

		// boolean res = donneesEmploye.insertEmploye(marc);
		System.out.println(res);
	}

	public static void createClientContrat() {

		IDonneesClientDAO donneesClient = DataInsertion.getDonneesClient();
		IDonneesEmployeDAO donneesEmploye = DataInsertion.getDonneesEmploye();

		/*
		 * Creation du client + affectation au manager 1
		 */

		Client richguy = new Client("RichEntreprise", "12345", "Richguy",
				"0123456789", "rguy@richE.com", "rguy", "rguy", "USA", null);

		Employe manager = donneesEmploye.getEmployeByNum(1);

		richguy.setEmploye(manager);
		// manager.getListeClients().add(richguy);

		/*
		 * création de son contrat
		 */
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, 1);
		Date dateFin = cal.getTime();
		Contrat contr = new Contrat(null, new Date(), dateFin, true, 2,
				new Date(), 12, "wahooo", true);

		richguy.getListeContrats().add(contr);
		contr.setClient(richguy);

		donneesClient.insertClient(richguy);

	}

	public static void installBouquet(int numerobouquet) {
		IDonneesBouquetDAO donneesBouquet = getDonneesBouquet();

		LoadingPolicy policies = new LoadingPolicy();
		policies.getPolicies().add("installation");

		Bouquet b = donneesBouquet.getBouquetByNumero(numerobouquet, policies);

		for (int i = 0; i < b.getQuantite(); i++) {
			Installation inst = new Installation(null, new Date(), new Date());
			b.getHistoriqueInstallations().add(inst);
			inst.getHistoriqueBouquet().add(b);
		}
		donneesBouquet.updateBouquet(b);

	}

	public static void createBouquetContrat(int contratId) {

		IDonneesContratDAO donneesContrat = getDonneesContrat();

		LoadingPolicy policies = new LoadingPolicy();
		policies.getPolicies().add("bouquet");

		Contrat contrat = donneesContrat.getContratById(contratId, policies);

		Bouquet bouquet = new Bouquet(null, 15);

		contrat.getListeBouquets().add(bouquet);
		bouquet.setContrat(contrat);
		/*
		 * for (Bouquet b : contrat.getListeBouquets()){
		 * System.out.println(b.toString()); }
		 */
		donneesContrat.updateContrat(contrat);

	}

	public static void removeInstallBouquet(int numBouquet) {
		IDonneesBouquetDAO donneesBouquet = DataInsertion.getDonneesBouquet();
		IDonneesInstallationDAO donneesInstallation = DataInsertion
				.getDonneesInstallation();

		LoadingPolicy policies = new LoadingPolicy();
		policies.getPolicies().add("installation");

		Bouquet b = donneesBouquet.getBouquetByNumero(numBouquet, policies);

		Set<Installation> saveSet = new HashSet<Installation>();

		Iterator<Installation> iter = b.getHistoriqueInstallations().iterator();

		while (iter.hasNext()) {
			saveSet.add(iter.next());
			iter.remove();
		}

		donneesBouquet.updateBouquet(b);

		donneesInstallation.deleteInstallationGroup(saveSet);

	}

	public static void createIncidentForInstall(int numInstall, int erreur,
			int stade) {
		IDonneesInstallationDAO donneesInstallation = DataInsertion
				.getDonneesInstallation();

		IDonneesIncidentDAO donneesIncident = DataInsertion
				.getDonneesIncident();

		Installation install = donneesInstallation.getInstallation(numInstall);

		Incident incident = new Incident(null, true, new Date(), new Date(),
				install);
		
		TypePb pb = donneesIncident.getTypePbById(erreur);
		
		incident.setTypePb(pb);
		

		/*
		 * 
		 * ajouter quelques StatutIncident
		 */

		StatutIncident statut;
		Intervention interv;

		TypeStatutIncident typesi;

		Calendar calendar = Calendar.getInstance();

		if (stade > 0) {

			// phase 1
			statut = new StatutIncident();
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			statut.setDateChangementStatut(calendar.getTime());
			statut.setCommentaire("constat");
			statut = setIntervention(statut, "diagnostic");
			
			typesi = donneesIncident.getTypeStatutIncidentById(1);
			
			statut.setTypeStatut(typesi);

			statut.setIncident(incident);
			incident.getListeStatutsIncidents().add(statut);
		}

		if (stade > 1) {
			// phase 2
			statut = new StatutIncident();
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			statut.setDateChangementStatut(calendar.getTime());
			statut.setCommentaire("pris en charge");
			statut = setIntervention(statut, "réparation");

			typesi = donneesIncident.getTypeStatutIncidentById(2);
			
			statut.setTypeStatut(typesi);			
			
			statut.setIncident(incident);
			incident.getListeStatutsIncidents().add(statut);
		}

		if (stade > 2) {
			// phase 3
			statut = new StatutIncident();
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			statut.setDateChangementStatut(calendar.getTime());
			statut.setCommentaire("résolu");
			
			typesi = donneesIncident.getTypeStatutIncidentById(3);
			
			statut.setTypeStatut(typesi);

			statut.setIncident(incident);
			incident.getListeStatutsIncidents().add(statut);
		}
		// ajout dans la base
		donneesIncident.insertIncident(incident);
	}

	public static StatutIncident setIntervention(StatutIncident statut,
			String comment) {
		Intervention interv = new Intervention();
		interv.setCommentaire(comment);
		interv.setDateDebutIntervention(new Date());
		interv.setDateFinIntervention(new Date());

		interv.setStatutIncident(statut);
		statut.setIntervention(interv);

		return statut;
	}

	public static void getAllIncidentsForClient(int numClient) {
		IDonneesIncidentDAO donneesIncident = DataInsertion
				.getDonneesIncident();

		List<Incident> listeIncident = donneesIncident
				.getSuiviIncidentByClient(numClient, -1, -1);

		for (Incident inc : listeIncident) {

			System.out.println("incident numero n°" + inc.getNumero()
					+ " a propos de " + "l'incident n°:"
					+ inc.getNumeroDeploiement().getNumero());

			for (StatutIncident stinc : inc.getListeStatutsIncidents()) {
				System.out.println("\t statut n°" + stinc.getNumero() + " : "
						+ stinc.getCommentaire());
			}

		}

	}

	public static void main(String[] args) {

		// BasicConfigurator.configure();

		// insertBasicData();
		// createClientContrat();

		// createBouquetContrat(1);

		// installBouquet(1);
		// removeInstallBouquet(1);

		 createIncidentForInstall(50,1,1);
		 createIncidentForInstall(51,2,2);
		 createIncidentForInstall(52,3,3);
		 createIncidentForInstall(53,3,4);
		 createIncidentForInstall(54,3,5);

		getAllIncidentsForClient(20);

	}

}
