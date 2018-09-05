package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.DependenteDAO;
import br.com.nrc.tiabete.dao.InsulinaDAO;
import br.com.nrc.tiabete.dao.InsulinaDependenteDAO;
import br.com.nrc.tiabete.dao.impl.DependenteDAOImpl;
import br.com.nrc.tiabete.dao.impl.InsulinaDAOImpl;
import br.com.nrc.tiabete.dao.impl.InsulinaDependenteDAOImpl;
import br.com.nrc.tiabete.entity.InsulinaDependente;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class InsulinaDependenteBO {

	private InsulinaDependenteDAO dao;

	private InsulinaDAO daoi;

	private DependenteDAO daod;

	private InsulinaDependente insuDep;

	public InsulinaDependenteBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		insuDep = new InsulinaDependente();

		dao = new InsulinaDependenteDAOImpl(em);
		daoi = new InsulinaDAOImpl(em);
		daod = new DependenteDAOImpl(em);
	}

	public List<InsulinaDependente> listar() {
		return dao.listar();
	}

	public InsulinaDependente pesquisar(int codInsu, int codDep) {
		insuDep.setInsulina(daoi.pesquisar(codInsu));
		insuDep.setDependente(daod.pesquisar(codDep));
		return insuDep;
	}

	public void inserir(InsulinaDependente insuDep) throws CommitException {
		dao.inserir(insuDep);
		dao.commit();
	}

	public void atualizar(InsulinaDependente insuDep, int codInsu, int codDep) throws CommitException {
		insuDep.getInsulina().setCodigo(codInsu);
		insuDep.getDependente().setCodigo(codDep);
		dao.atualizar(insuDep);
		dao.commit();
	}

	public void remover(int codInsu, int codDep) throws CommitException, KeyNotFoundException {

		insuDep.getInsulina().setCodigo(codInsu);
		insuDep.getDependente().setCodigo(codDep);
		dao.removerPorEntidade(insuDep);
		dao.commit();
	}
}
