package br.com.nrc.tiabete.dao.test;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.InsulinaDependenteDAO;
import br.com.nrc.tiabete.dao.impl.InsulinaDependenteDAOImpl;
import br.com.nrc.tiabete.entity.Dependente;
import br.com.nrc.tiabete.entity.Insulina;
import br.com.nrc.tiabete.entity.InsulinaDependente;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class InsulinaDependenteTeste {

	public static void main(String[] args) throws CommitException {
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		
		InsulinaDependenteDAO dao = new InsulinaDependenteDAOImpl(em);
		InsulinaDependente insulinaDependente = new InsulinaDependente();
		
		
		
		Insulina insulina = new Insulina();
		Dependente dependente = new Dependente();
		
		
		 insulinaDependente.setInsulina(insulina);
		 insulinaDependente.setDependente(dependente);
		
		 
		 dao.inserir(insulinaDependente);
		 dao.commit();
		 em.close();
		
	}
	
}
