package fr.afcepf.ai77.g1.persistence.implementations;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.Collection;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import fr.afcepf.ai77.g1.persistence.entity.Bouquet;
import fr.afcepf.ai77.g1.persistence.entity.Contrat;
import fr.afcepf.ai77.g1.persistence.entity.Incident;
import fr.afcepf.ai77.g1.persistence.entity.Intervention;
import fr.afcepf.ai77.g1.persistence.entity.LoadingPolicy;
import fr.afcepf.ai77.g1.persistence.entity.StatutIncident;
import fr.afcepf.ai77.g1.persistence.entity.TypePb;
import fr.afcepf.ai77.g1.persistence.entity.TypeStatutIncident;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesIncidentDAO;

public class DonneesIncidentDAOImpl implements IDonneesIncidentDAO {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sf) {
		hibernateTemplate = new HibernateTemplate(sf);
	}

	@Override
	public List<Incident> getIncidentByContrat(int numContrat) {
		return null;
	}

	@Override
	public List<Incident> getLastIncidentByClient(
			final int numClient) {

		List<Incident> listLastContratFlagguesParClient = hibernateTemplate
				.execute(new HibernateCallback<List<Incident>>() {
					@Override
					public List<Incident> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<Incident> liste;
						Criteria crit = session.createCriteria(Incident.class);
						crit = crit.add(Restrictions.eq("flag", true)).addOrder(
								Order.desc("dateDeclarationIncident")).createCriteria(
								"client", Criteria.INNER_JOIN).add(
								Restrictions.eq("numero", numClient))
								.setMaxResults(7);
						// là on a tous les contrats flaggués d'un client
						liste = crit.list();
						
						int reste = 7 - liste.size();
						
						if (reste>0){
							List<Incident> listNonFlag;
							crit = session.createCriteria(Incident.class);
							crit = crit.add(Restrictions.eq("flag", false)).addOrder(
									Order.desc("dateDeclarationIncident")).createCriteria(
									"client", Criteria.INNER_JOIN).add(
									Restrictions.eq("numero", numClient))
									.setMaxResults(reste);
							// là on a tous les contrats flaggués d'un client
							listNonFlag = crit.list();	
							liste.addAll(listNonFlag);
							for (Incident incident: liste) {
								Hibernate.initialize(incident);
								//décommenter ce qu'on a besoin 
								//Hibernate.initialize(incident.getClient());
								
									Hibernate.initialize(incident.getListeStatutsIncidents());
									Hibernate.initialize(incident.getNumeroDeploiement());
									Hibernate.initialize(incident.getTypePb());
								
									for (StatutIncident stinc : incident
											.getListeStatutsIncidents()) {
										Hibernate.initialize(stinc);
										Hibernate.initialize(stinc.getTypeStatut());
									}
								}

						}

						return liste;
						
					} });
		return listLastContratFlagguesParClient;}
	
	@Override
	public Incident getIncidentByNumero(int numero) {

		try {
			Incident incident = hibernateTemplate.get(Incident.class, numero);
			return incident;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Incident getIncidentByNumero(final int numero,
			final LoadingPolicy policies) {
		// TODO Auto-generated method stub
		Incident incident = null;
		try {

			incident = hibernateTemplate
					.execute(new HibernateCallback<Incident>() {
						@Override
						public Incident doInHibernate(Session session)
								throws HibernateException, SQLException {
							// TODO Auto-generated method stub
							Incident tempc = (Incident) session.get(
									Incident.class, numero);

							if (policies != null) {
								Hibernate.initialize(tempc);
								for (String policy : policies.getPolicies()) {

									if (policy.equals("installation")) {
										Hibernate.initialize(tempc
												.getNumeroDeploiement());
										continue;
									}

									if (policy.equals("statutIncident")) {
										Hibernate.initialize(tempc
												.getListeStatutsIncidents());
										for (StatutIncident stinc : tempc
												.getListeStatutsIncidents()) {
											Hibernate.initialize(stinc);
										}
										continue;
									}

									if (policy.equals("intervention")) {
										for (StatutIncident stinc : tempc
												.getListeStatutsIncidents()) {
											Hibernate.initialize(stinc);
											Hibernate.initialize(stinc
													.getIntervention());
										}
										continue;
									}

								}

							}

							return tempc;
						}
					});

		} catch (Exception e) {
			e.printStackTrace();
			incident = null;
		} finally {
			return incident;
		}
	}

	
	/*
	 * 
	 * (non-Javadoc)
	 * @see fr.afcepf.ai77.g1.persistence.interfaces.IDonneesIncidentDAO#insertIncident(fr.afcepf.ai77.g1.persistence.entity.Incident)
	 * 
	 * maintenant, on ins�re aussi le statut incident � la vol�e
	 */
	
	@Override
	public Integer insertIncident(Incident incident) {
		try {
			
			StatutIncident statut = new StatutIncident();
			statut.setDateChangementStatut(incident.getDateDeclarationIncident());
			
			//commenter les 3 lignes suivantes si besoin. bug incompréhensible quand on insère via createData
			TypeStatutIncident type = getTypeStatutIncidentById(1);
			
			statut.setTypeStatut(type);	
			statut.setIncident(incident);
			incident.getListeStatutsIncidents().add(statut);
			
			hibernateTemplate.save(incident);

			// normalement, hibernate affecte le numero lui m�me (merci Youssef !)
			return incident.getNumero();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	/**************************************************************************
	 * R�cup�rer des incidents pour un client
	 **************************************************************************/

	@Override
	public List<Incident> getSuiviIncidentByClient(Integer clientID) {
		// TODO Auto-generated method stub
		return getSuiviIncidentByClient(clientID, false, -1, -1);

	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see fr.afcepf.ai77.g1.persistence.interfaces.IDonneesIncidentDAO#
	 * getSuiviIncidentByclient(java.lang.Integer, boolean)
	 * 
	 * todo : des qu'on est au point avec les type_statut_incident, ajouter les
	 * criteres pour g�rer le cas des incidents r�solus en fonction de
	 * unfinishedOnly
	 */

	@Override
	public List<Incident> getSuiviIncidentByclient(Integer clientID,
			boolean unfinishedOnly) {
		// TODO Auto-generated method stub

		return getSuiviIncidentByClient(clientID, unfinishedOnly, -1, -1);

	}

	@Override
	public List<Incident> getSuiviIncidentByClient(Integer clientID, int min,
			int max) {
		// TODO Auto-generated method stub
		return getSuiviIncidentByClient(clientID, false, min, max);
	}

	@Override
	public List<Incident> getSuiviIncidentByClient(final Integer clientID,
			final boolean unfinishedOnly, final int min, final int max) {
		// TODO Auto-generated method stub

		List<Incident> listIncident = null;

		try {

			listIncident = hibernateTemplate
					.execute(new HibernateCallback<List<Incident>>() {
						@Override
						public List<Incident> doInHibernate(Session session)
								throws HibernateException, SQLException {

							/*
							 * premiere etape ;
							 */

							List<Incident> liste = new Vector<Incident>();
							List<Incident> reliste = new Vector<Incident>();

							/*
							 * premiere etape : cherche la liste des incidents
							 */

							/*
							 * Query query = session.createQuery(
							 * "select myincident from Incident as myincident "
							 * +
							 * "inner join myincident.numeroDeploiement as instal "
							 * +
							 * "inner join instal.historiqueBouquet as bouquet "
							 * + "inner join bouquet.contrat as contrat " +
							 * "inner join contrat.client as client " +
							 * "where client.numero=:clientID" );
							 * 
							 * 
							 * 
							 * query.setInteger("clientID", clientID);
							 * 
							 * 
							 * liste = query.list();
							 */

							Criteria critere = session.createCriteria(
									Incident.class).addOrder(
									Order.desc("dateDeclarationIncident"));

							// FIXME : mettre la gestion de la restriction
							// sur les interventions termin�es ici

							critere = critere
									.createCriteria("numeroDeploiement",
											Criteria.INNER_JOIN)
									.createCriteria("historiqueBouquet",
											Criteria.INNER_JOIN)
									.createCriteria("contrat",
											Criteria.INNER_JOIN)
									.createCriteria("client",
											Criteria.INNER_JOIN)
									.add(Expression.eq("numero", new Integer(
											clientID)));

							liste = critere.list();

							/*
							 * raffiner les r�sultats en fonction des min et max
							 */

							int minimum = (min < 0) ? 0 : min;
							int maximum = (max < 0) ? liste.size() : max;
							int compteur = 0;

							Iterator<Incident> iter = liste.iterator();

							while (iter.hasNext()) {
								Incident inc = iter.next();
								if ((compteur >= minimum)
										&& (compteur < maximum)) {
									reliste.add(inc);
								}

								compteur++;
							}

							/*
							 * deuxieme etape : charger les StatutIncidents, les
							 * interventions , les employes en charge des
							 * interventions
							 */

							for (Incident incident : reliste) {
								Hibernate.initialize(incident);
								Hibernate.initialize(incident.getTypePb());

								Hibernate.initialize(incident
										.getListeStatutsIncidents());

								Hibernate.initialize(incident
										.getNumeroDeploiement());

								for (StatutIncident stinc : incident
										.getListeStatutsIncidents()) {
									Hibernate.initialize(stinc);
									Hibernate.initialize(stinc.getTypeStatut());
									Hibernate.initialize(stinc
											.getIntervention());

									if (stinc.getIntervention() != null)
										Hibernate
												.initialize(stinc
														.getIntervention()
														.getEmploye());

								}

							}

							return reliste;
						}
					});

		} catch (Exception e) {
			e.printStackTrace();
			listIncident = null;
		} finally {
			return listIncident;
		}
	}

	@Override
	public TypePb getTypePbById(int problemeId) {
		// TODO Auto-generated method stub
		TypePb typepb = null;
		try {
			typepb = hibernateTemplate.get(TypePb.class, problemeId);
		} catch (Exception e) {
			e.printStackTrace();
			typepb = null;
		} finally {
			return typepb;
		}
	}

	@Override
	public TypeStatutIncident getTypeStatutIncidentById(int numeroStatut) {
		// TODO Auto-generated method stub
		TypeStatutIncident typesi = null;
		try {
			typesi = hibernateTemplate.get(TypeStatutIncident.class,
					numeroStatut);
		} catch (Exception e) {
			e.printStackTrace();
			typesi = null;
		} finally {
			return typesi;
		}
	}

	@Override
	public boolean updateIncident(Incident incident) {
		// TODO Auto-generated method stub
		boolean res=false;
		try{
			hibernateTemplate.update(incident);
			res=true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return res;
		}
	}

}
