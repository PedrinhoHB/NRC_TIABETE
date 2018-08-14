package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.DependenteDAO;
import br.com.nrc.tiabete.dao.impl.DependenteDAOImpl;
import br.com.nrc.tiabete.entity.Dependente;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class DependenteBO {
	private DependenteDAO dao;

	public DependenteBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new DependenteDAOImpl(em);
	}

	public List<Dependente> listar() {
		return dao.listar();
	}

	public Dependente pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(Dependente dependente) throws CommitException {
		dao.inserir(dependente);
		dao.commit();
	}

	public void insereComDtCriacao(Dependente dependente) throws CommitException {
		dao.insereComDtCriacao(dependente);
		dao.commit();
	}

	public void atualizar(Dependente dependente, int codigo) throws CommitException {
		dependente.setCodigo(codigo);
		dao.atualizar(dependente);
		dao.commit();
	}

	public void atualizaComDtUltAlteracao(Dependente dependente, int codigo) throws CommitException {
		dao.atualizaComDtUltAlteracao(dependente, codigo);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
