package fr.afcepf.ai77.g1.persistence.implementations;

import java.sql.SQLException;
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
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import fr.afcepf.ai77.g1.persistence.entity.Contrat;
import fr.afcepf.ai77.g1.persistence.entity.Incident;
import fr.afcepf.ai77.g1.persistence.entity.StatutIncident;
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
	public Integer insertIncident(Incident incident) {
		try{
			hibernateTemplate.save(incident);
			
			//FIXME : retourner le vrai max
			return 0;
		}catch(Exception e){
			e.printStackTrace();return -1;
		}
		
	}
	
	
	@Override
	public List<Incident> getSuiviIncidentByClient(final Integer clientID) {
		// TODO Auto-generated method stub
		
		List<Incident> listIncident = null;		
		
		try {
			
			listIncident = hibernateTemplate.execute(new HibernateCallback<List<Incident>>() {
				@Override
				public List<Incident> doInHibernate(Session session) throws HibernateException,
						SQLException {
					
					/*
					 * premiere etape ; 
					 */
					
					List<Incident> liste = new Vector<Incident>();
					
					/*
					 * premiere etape : cherche la liste des incidents
					 */
				/*	
					Query query = session.createQuery("select myincident from Incident as myincident " +
							"inner join myincident.numeroDeploiement as instal " +
							"inner join instal.historiqueBouquet as bouquet " +
							"inner join bouquet.contrat as contrat " +
							"inner join contrat.client as client " +
							"where client.numero=:clientID" );
			
					
					
				    query.setInteger("clientID", clientID);
					
					
					liste = query.list();
					
				*/
					
					Criteria critere = session.createCriteria(Incident.class)
					.createCriteria("numeroDeploiement",Criteria.INNER_JOIN)
					.createCriteria("historiqueBouquet", Criteria.INNER_JOIN)
					.createCriteria("contrat",Criteria.INNER_JOIN)
					.createCriteria("client", Criteria.INNER_JOIN)					
					.add(Expression.eq("numero", new Integer(clientID)));
					
				
					liste = critere.list();
					
					/*
					 * deuxieme etape : charger 
					 * 	les StatutIncidents, 
					 * 	les interventions
					 * 	, 
					 * 
					 */
					
					for (Incident incident : liste){
						Hibernate.initialize(incident);
						
						Hibernate.initialize(incident.getListeStatutsIncidents());
						
						for (StatutIncident stinc : incident.getListeStatutsIncidents()){
							Hibernate.initialize(stinc);
							Hibernate.initialize(stinc.getIntervention());
						}
						
					}
					
					
							
					return liste;
				}
			});
			
			
		} catch (Exception e) {
			e.printStackTrace();
			listIncident = null;
		} finally {
			return listIncident;
		}		
		
	}
	
	
}
