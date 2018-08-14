package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.CategoriaInsulinaDAO;
import br.com.nrc.tiabete.dao.impl.CategoriaInsulinaDAOImpl;
import br.com.nrc.tiabete.entity.CategoriaInsulina;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class CategoriaInsulinaBO {
	private CategoriaInsulinaDAO dao;

	public CategoriaInsulinaBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new CategoriaInsulinaDAOImpl(em);
	}

	public List<CategoriaInsulina> listar() {
		return dao.listar();
	}

	public CategoriaInsulina pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(CategoriaInsulina catInsu) throws CommitException {
		dao.inserir(catInsu);
		dao.commit();
	}

	public void atualizar(CategoriaInsulina catInsu, int codigo) throws CommitException {
		catInsu.setCodigo(codigo);
		dao.atualizar(catInsu);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
