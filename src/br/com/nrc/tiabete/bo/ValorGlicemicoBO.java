package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.ValorGlicemicoDAO;
import br.com.nrc.tiabete.dao.impl.ValorGlicemicoDAOImpl;
import br.com.nrc.tiabete.entity.ValorGlicemico;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class ValorGlicemicoBO {
	private ValorGlicemicoDAO dao;

	public ValorGlicemicoBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new ValorGlicemicoDAOImpl(em);
	}

	public List<ValorGlicemico> listar() {
		return dao.listar();
	}

	public ValorGlicemico pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(ValorGlicemico valGlic) throws CommitException {
		dao.inserir(valGlic);
		dao.commit();
	}

	public void atualizar(ValorGlicemico valGlic, int codigo) throws CommitException {
		valGlic.setCodigo(codigo);
		dao.atualizar(valGlic);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
