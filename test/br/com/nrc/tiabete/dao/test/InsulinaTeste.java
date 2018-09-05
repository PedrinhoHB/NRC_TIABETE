package br.com.nrc.tiabete.dao.test;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.InsulinaDAO;
import br.com.nrc.tiabete.dao.impl.InsulinaDAOImpl;
import br.com.nrc.tiabete.entity.CategoriaInsulina;
import br.com.nrc.tiabete.entity.Insulina;
import br.com.nrc.tiabete.entity.TipoInsulina;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class InsulinaTeste {
	public static void main(String[] args) throws CommitException {
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		
		
		CategoriaInsulina catInsulina =  new CategoriaInsulina();
		TipoInsulina tipoInsulina = new TipoInsulina();
		
		catInsulina.setDescricao("Novolin");
		tipoInsulina.setDescricao("Lispro");
		
		InsulinaDAO dao = new InsulinaDAOImpl(em);
		Insulina insulina = new Insulina();
		
		insulina.setNome("insulinaboa");
		insulina.setCategoriaInsulina(catInsulina);
		insulina.setTipoInsulina(tipoInsulina);
		
		
		dao.inserir(insulina);
		dao.commit();

		em.close();
		
	}
	
}
