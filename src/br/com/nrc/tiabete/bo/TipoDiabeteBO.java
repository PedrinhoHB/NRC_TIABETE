package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.TipoDiabeteDAO;
import br.com.nrc.tiabete.dao.impl.TipoDiabeteDAOImpl;
import br.com.nrc.tiabete.entity.TipoDiabete;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class TipoDiabeteBO {
	private TipoDiabeteDAO dao;

	public TipoDiabeteBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new TipoDiabeteDAOImpl(em);
	}

	public List<TipoDiabete> listar() {
		return dao.listar();
	}

	public TipoDiabete pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(TipoDiabete tipoDia) throws CommitException {
		dao.inserir(tipoDia);
		dao.commit();
	}

	public void atualizar(TipoDiabete tipoDia, int codigo) throws CommitException {
		tipoDia.setCodigo(codigo);
		dao.atualizar(tipoDia);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
