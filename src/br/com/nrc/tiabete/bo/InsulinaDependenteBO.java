package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.DependenteDAO;
import br.com.nrc.tiabete.dao.InsulinaDAO;
import br.com.nrc.tiabete.dao.InsulinaDependenteDAO;
import br.com.nrc.tiabete.dao.impl.DependenteDAOImpl;
import br.com.nrc.tiabete.dao.impl.InsulinaDAOImpl;
import br.com.nrc.tiabete.dao.impl.InsulinaDependenteDAOImpl;
import br.com.nrc.tiabete.entity.Dependente;
import br.com.nrc.tiabete.entity.Insulina;
import br.com.nrc.tiabete.entity.InsulinaDependente;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class InsulinaDependenteBO {
	private InsulinaDependenteDAO dao;

	private InsulinaDAO daoInsu;

	private DependenteDAO daoDep;

	public InsulinaDependenteBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new InsulinaDependenteDAOImpl(em);
		daoInsu = new InsulinaDAOImpl(em);
		daoDep = new DependenteDAOImpl(em);
	}

	public List<InsulinaDependente> listar() {
		return dao.listar();
	}

	public InsulinaDependente pesquisar(int codInsu, int codDep) {
		Insulina insulina = daoInsu.pesquisar(codInsu);
		Dependente dependente = daoDep.pesquisar(codDep);
		InsulinaDependente insuDep = new InsulinaDependente();
		insuDep.setInsulina(insulina);
		insuDep.setDependente(dependente);

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
		daoInsu.remover(codInsu);
		daoDep.remover(codDep);
		daoInsu.commit();
		daoDep.commit();
	}
}
