package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.AplicacaoDAO;
import br.com.nrc.tiabete.dao.impl.AplicacaoDAOImpl;
import br.com.nrc.tiabete.entity.Aplicacao;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class AplicacaoBO {
	private AplicacaoDAO dao;

	public AplicacaoBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new AplicacaoDAOImpl(em);
	}

	public List<Aplicacao> listar() {
		return dao.listar();
	}

	public Aplicacao pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(Aplicacao aplicacao) throws CommitException {
		dao.inserir(aplicacao);
		dao.commit();
	}

	public void atualizar(Aplicacao aplicacao, int codigo) throws CommitException {
		aplicacao.setCodigo(codigo);
		dao.atualizar(aplicacao);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
