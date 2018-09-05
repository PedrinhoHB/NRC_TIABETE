package br.com.nrc.tiabete.dao.test;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.RemedioDAO;
import br.com.nrc.tiabete.dao.impl.RemedioDAOImpl;
import br.com.nrc.tiabete.entity.Remedio;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class RemedioTeste {
	public static void main(String[] args) throws CommitException {
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		
		RemedioDAO dao = new RemedioDAOImpl(em);
		Remedio remedio = new Remedio();
		
		remedio.setNome("paracetamal");
		remedio.setTipo("Oral");
		
		dao.inserir(remedio);
		 dao.commit();
		 em.close();
		
	}
	
}
