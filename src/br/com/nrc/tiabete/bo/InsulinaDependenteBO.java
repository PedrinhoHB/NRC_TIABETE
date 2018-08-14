package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.InsulinaDependenteDAO;
import br.com.nrc.tiabete.dao.impl.InsulinaDependenteDAOImpl;
import br.com.nrc.tiabete.entity.InsulinaDependente;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class InsulinaDependenteBO {
	private InsulinaDependenteDAO dao;

	public InsulinaDependenteBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new InsulinaDependenteDAOImpl(em);
	}

	public List<InsulinaDependente> listar() {
		return dao.listar();
	}

	public InsulinaDependente pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(InsulinaDependente insuDep) throws CommitException {
		dao.inserir(insuDep);
		dao.commit();
	}

	public void atualizar(InsulinaDependente insuDep, int codigo) throws CommitException {
		// TODO Verificar com o professor
		insuDep.getInsulina().setCodigo(codigo);
		insuDep.getDependente().setCodigo(codigo);
		dao.atualizar(insuDep);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
