package fr.afcepf.ai77.g1.persistence.implementations;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import fr.afcepf.ai77.g1.persistence.entity.Contrat;
import fr.afcepf.ai77.g1.persistence.entity.Formule;
import fr.afcepf.ai77.g1.persistence.entity.LoadingPolicy;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesContratDAO;

public class DonneesContratDAOImpl implements IDonneesContratDAO {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sf) {
		hibernateTemplate = new HibernateTemplate(sf);
	}

	@Override
	public Contrat getContratById(Integer id) {
		// TODO Auto-generated method stub
		Contrat c = null;
		try {
			c = hibernateTemplate.get(Contrat.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return c;
		}
	}

	
	/**
	 * 
	 * Raaahlala ce qu'il faut pas faire, p#%*n de m$¤€e !
	 * 
	 */
	@Override
	public Contrat getContratById(final Integer id, final LoadingPolicy policies) {
		// TODO Auto-generated method stub
		Contrat c = null;
		try {
			
			c = hibernateTemplate.execute(new HibernateCallback<Contrat>() {
				@Override
				public Contrat doInHibernate(Session session) throws HibernateException,
						SQLException {
					// TODO Auto-generated method stub
					Contrat tempc = (Contrat)session.get(Contrat.class, id);
					
					if (policies!=null){
						Hibernate.initialize(tempc);
						for (String policy : policies.getPolicies()){
							if (policy.equals("bouquet")){
								Hibernate.initialize(tempc.getListeBouquets());
								continue;
							}
						}
						
					}
					
					
					return tempc;
				}
			});
			
			
		} catch (Exception e) {
			e.printStackTrace();
			c = null;
		} finally {
			return c;
		}
	}

	@Override
	public List<Formule> getAllFormule() {
		List<Formule> tteFormules = hibernateTemplate.find("from Formule");
		return tteFormules;
	}

	@Override
	public boolean updateContrat(Contrat contrat) {
		// TODO Auto-generated method stub
		Boolean result = true;
		try {
			hibernateTemplate.saveOrUpdate(contrat);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			return result;
		}

	}

}
