package fr.afcepf.ai77.g1.persistence.implementations;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import fr.afcepf.ai77.g1.persistence.entity.Employe;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesEmployeDAO;

public class DonneesEmployeDAOImpl implements IDonneesEmployeDAO {

	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sf) {
		hibernateTemplate = new HibernateTemplate(sf);
	}

	@Override
	public boolean insertEmploye(Employe ep) {
		// TODO Auto-generated method stub
		try{
			hibernateTemplate.save(ep);
			return true;
		}catch(Exception e){
		//	e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Employe getEmployeByNum(int id) {
		// TODO Auto-generated method stub
		Employe toreturn = null;
		try{
			toreturn = hibernateTemplate.get(Employe.class, new Integer(id));
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return toreturn;
		}
		
	}

}
