package fr.afcepf.ai77.g1.persistence.implementations;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Junction;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import fr.afcepf.ai77.g1.persistence.entity.Contrat;
import fr.afcepf.ai77.g1.persistence.entity.Incident;
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
			
			
			/*
			Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
			
			Query q = session.createQuery("max(numero_incident) from Incident c");
			
			Integer i = (Integer) q.uniqueResult();
			
			return i;*/
			
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
					List<Incident> liste = new Vector<Incident>();
					
					Query query = session.createQuery("from Incident " +
							"where cat.numeroDeploiement.historiqueBouquet.contrat.client.id = :idClient " );
					
					query.setInteger(1, clientID);
					
					liste = query.list();
							
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
