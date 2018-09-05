package br.com.nrc.tiabete.dao.test;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.AplicacaoDAO;
import br.com.nrc.tiabete.dao.impl.AplicacaoDAOImpl;
import br.com.nrc.tiabete.entity.Aplicacao;
import br.com.nrc.tiabete.entity.Dependente;
import br.com.nrc.tiabete.entity.Insulina;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class AplicacaoTest {
	public static void main(String[] args) throws CommitException {
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		
		AplicacaoDAO dao = new AplicacaoDAOImpl(em);
		Aplicacao aplicacao = new Aplicacao();
		
		Insulina insulina = new Insulina();
		Dependente dependente = new Dependente();
		
		aplicacao.setInsulina(insulina);
		aplicacao.setValorEscala(2.5);
		aplicacao.setDependente(dependente);
		
		
		dao.inserir(aplicacao);
		dao.commit();

		em.close();
		
		}
}
