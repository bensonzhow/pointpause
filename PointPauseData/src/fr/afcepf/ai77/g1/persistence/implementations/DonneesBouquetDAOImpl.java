package fr.afcepf.ai77.g1.persistence.implementations;

import java.sql.SQLException;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import fr.afcepf.ai77.g1.persistence.entity.Bouquet;
import fr.afcepf.ai77.g1.persistence.entity.Contrat;
import fr.afcepf.ai77.g1.persistence.entity.LoadingPolicy;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesBouquetDAO;

public class DonneesBouquetDAOImpl implements IDonneesBouquetDAO {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sf) {
		hibernateTemplate = new HibernateTemplate(sf);
	}

	@Override
	public Bouquet getBouquetByNumero(int bouquetID) {
		// TODO Auto-generated method stub
		Bouquet b = null;
		try {
			b = hibernateTemplate.get(Bouquet.class, bouquetID);
		} catch (Exception e) {
			e.printStackTrace();
			b = null;
		} finally {
			return b;
		}

	}

	@Override
	public Bouquet getBouquetByNumero(final int bouquetID,
			final LoadingPolicy policies) {
		// TODO Auto-generated method stub
		Bouquet b = null;
		try {

			b = hibernateTemplate.execute(new HibernateCallback<Bouquet>() {
				@Override
				public Bouquet doInHibernate(Session session)
						throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					Bouquet tempb = (Bouquet) session.get(Bouquet.class,
							bouquetID);

					if (policies != null) {
						Hibernate.initialize(tempb);
						for (String policy : policies.getPolicies()) {
							if (policy.equals("installation")) {
								Hibernate.initialize(tempb
										.getHistoriqueInstallations());
								continue;
							}
						}

					}

					return tempb;
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
			b = null;
		} finally {
			return b;
		}

	}
	
	
	@Override
	public boolean updateBouquet(Bouquet bouquet) {
		// TODO Auto-generated method stub
		Boolean result = true;
		try {
			hibernateTemplate.saveOrUpdate(bouquet);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			return result;
		}
	}
	
}
