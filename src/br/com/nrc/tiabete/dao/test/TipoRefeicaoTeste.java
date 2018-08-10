package br.com.nrc.tiabete.dao.test;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.TipoRefeicaoDAO;
import br.com.nrc.tiabete.dao.impl.TipoRefeicaoDAOImpl;
import br.com.nrc.tiabete.entity.TipoRefeicao;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class TipoRefeicaoTeste {

	public static void main(String[] args) throws CommitException {
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		
		TipoRefeicaoDAO dao = new TipoRefeicaoDAOImpl(em);
		TipoRefeicao tipoRefeicao = new TipoRefeicao();
		
		
		tipoRefeicao.setDescricao("Calorica");
		
		dao.inserir(tipoRefeicao);
		dao.commit();

		em.close();
		
	}
}
