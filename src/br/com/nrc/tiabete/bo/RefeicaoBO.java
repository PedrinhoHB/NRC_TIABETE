package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.RefeicaoDAO;
import br.com.nrc.tiabete.dao.impl.RefeicaoDAOImpl;
import br.com.nrc.tiabete.entity.Refeicao;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class RefeicaoBO {
	private RefeicaoDAO dao;

	public RefeicaoBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new RefeicaoDAOImpl(em);
	}

	public List<Refeicao> listar() {
		return dao.listar();
	}

	public Refeicao pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(Refeicao refeicao) throws CommitException {
		dao.inserir(refeicao);
		dao.commit();
	}

	public void atualizar(Refeicao refeicao, int codigo) throws CommitException {
		refeicao.setCodigo(codigo);
		dao.atualizar(refeicao);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
