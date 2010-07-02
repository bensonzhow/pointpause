package fr.afcepf.ai77.g1.persistence.implementations;

import java.sql.SQLException;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import fr.afcepf.ai77.g1.persistence.entity.Installation;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesInstallationDAO;

public class DonneesInstallationDAOImpl implements IDonneesInstallationDAO {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sf) {
		hibernateTemplate = new HibernateTemplate(sf);
	}

	@Override
	public boolean deleteInstallation(int numInstall) {
		// TODO Auto-generated method stub
		boolean result = true;
		try {
			Installation install = hibernateTemplate.get(Installation.class,
					numInstall);
			hibernateTemplate.delete(install);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			return result;
		}

	}

	@Override
	public boolean deleteInstallation(Installation install) {
		// TODO Auto-generated method stub
		boolean result = true;
		try {
			hibernateTemplate.delete(install);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			return result;
		}
	}
	
	@Override
	public boolean deleteInstallationGroup(final Set<Installation> instalset) {
		// TODO Auto-generated method stub
		boolean result = true;
		try {
			
			result = hibernateTemplate.execute(new HibernateCallback<Boolean>() {
				@Override
				public Boolean doInHibernate(Session arg0)
						throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					boolean res=true;
					Transaction tx = arg0.beginTransaction();
					tx.begin();
					try{
						for (Installation install : instalset){
							//Installation reinstall = (Installation) arg0.get(Installation.class, install.getNumero());
							arg0.delete(install);
						}
						tx.commit();
					}catch(Exception e){
						e.printStackTrace();
						res=false;
						tx.rollback();
					}finally{
						return res;
					}
					
					
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			return result;
		}		
	}

}
