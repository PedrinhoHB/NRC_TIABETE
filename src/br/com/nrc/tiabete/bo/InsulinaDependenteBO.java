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
import br.com.nrc.tiabete.entity.InsulinaDependentePK;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class InsulinaDependenteBO {
	private InsulinaDependenteDAO dao;

	private InsulinaDAO daoInsu;

	private DependenteDAO daoDep;

	private InsulinaDependentePK pk;

	public InsulinaDependenteBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new InsulinaDependenteDAOImpl(em);
		daoInsu = new InsulinaDAOImpl(em);
		daoDep = new DependenteDAOImpl(em);
		pk = new InsulinaDependentePK();
	}

	public List<InsulinaDependente> listar() {
		return dao.listar();
	}

	public InsulinaDependente pesquisar(int codInsu, int codDep) {
		// TODO Verificar
		InsulinaDependente insuDep = new InsulinaDependente();
		insuDep.setInsulina(daoInsu.pesquisar(codInsu));
		insuDep.setDependente(daoDep.pesquisar(codDep));

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
		// TODO Verificar
		pk.setInsulina(codInsu);
		pk.setDependente(codDep);
		dao.remover(pk.hashCode());
		dao.commit();
	}
}
