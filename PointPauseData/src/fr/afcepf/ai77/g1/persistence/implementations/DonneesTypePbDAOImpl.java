package fr.afcepf.ai77.g1.persistence.implementations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import fr.afcepf.ai77.g1.persistence.entity.TypePb;
import fr.afcepf.ai77.g1.persistence.interfaces.IDonneesTypePbDAO;

public class DonneesTypePbDAOImpl implements IDonneesTypePbDAO {
	
	private HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sf) {
		hibernateTemplate = new HibernateTemplate(sf);
	}
		

	@Override
	public TypePb getTypePbByNumero(int numero) {
		// TODO Auto-generated method stub
		TypePb tpb = null;
		try{
			tpb = hibernateTemplate.get(TypePb.class, numero);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			return tpb;
		}
		
	}

	@Override
	public Integer insertTypePb(TypePb typePb) {
		// TODO Auto-generated method stub
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<String> getTypePb() {
		List<String> typePb = new ArrayList<String>();
		try {
			typePb = hibernateTemplate
					.find("libelle_type_probleme");
		} catch (Exception e) {
			System.out.println("Récuperation des type de poblemes impossible...");
		}
		return typePb;
	}

}
