package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.ResponsavelDAO;
import br.com.nrc.tiabete.dao.impl.ResponsavelDAOImpl;
import br.com.nrc.tiabete.entity.Responsavel;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class ResponsavelBO {
	private ResponsavelDAO dao;

	public ResponsavelBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new ResponsavelDAOImpl(em);
	}

	public List<Responsavel> listar() {
		return dao.listar();
	}

	public Responsavel pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(Responsavel responsavel) throws CommitException {
		dao.inserir(responsavel);
		dao.commit();
	}

	public void atualizar(Responsavel responsavel, int codigo) throws CommitException {
		responsavel.setCodigo(codigo);
		dao.atualizar(responsavel);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
