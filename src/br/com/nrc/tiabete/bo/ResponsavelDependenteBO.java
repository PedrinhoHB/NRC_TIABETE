package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.ResponsavelDependenteDAO;
import br.com.nrc.tiabete.dao.impl.ResponsavelDependenteDAOImpl;
import br.com.nrc.tiabete.entity.ResponsavelDependente;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class ResponsavelDependenteBO {
	private ResponsavelDependenteDAO dao;

	public ResponsavelDependenteBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new ResponsavelDependenteDAOImpl(em);
	}

	public List<ResponsavelDependente> listar() {
		return dao.listar();
	}

	public ResponsavelDependente pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(ResponsavelDependente respDep) throws CommitException {
		dao.inserir(respDep);
		dao.commit();
	}

	public void atualizar(ResponsavelDependente respDep, int codigo) throws CommitException {
		// TODO Verificar com o professor
		respDep.getResponsavel().setCodigo(codigo);
		respDep.getDependente().setCodigo(codigo);
		dao.atualizar(respDep);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
