package br.com.nrc.tiabete.dao.test;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.TipoInsulinaDAO;
import br.com.nrc.tiabete.dao.impl.TipoInsulinaDAOImpl;
import br.com.nrc.tiabete.entity.TipoInsulina;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class TipoInsulinaTeste {
	public static void main(String[] args) throws CommitException {
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		
		TipoInsulinaDAO dao = new TipoInsulinaDAOImpl(em);
		TipoInsulina tipoinsulina = new TipoInsulina();
		
		tipoinsulina.setDescricao("Normal");
		
		
		dao.inserir(tipoinsulina);
		dao.commit();

		em.close();
		
	}
}
