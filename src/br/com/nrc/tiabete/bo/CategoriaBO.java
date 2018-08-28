package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.CategoriaDAO;
import br.com.nrc.tiabete.dao.impl.CategoriaDAOImpl;
import br.com.nrc.tiabete.entity.news.Categoria;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class CategoriaBO {
	private CategoriaDAO dao;

	public CategoriaBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new CategoriaDAOImpl(em);
	}

	public List<Categoria> listar() {
		return dao.listar();
	}

	public Categoria pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(Categoria categoria) throws CommitException {
		dao.inserir(categoria);
		dao.commit();
	}

	public void atualizar(Categoria categoria, int codigo) throws CommitException {
		categoria.setCodigo(codigo);
		dao.atualizar(categoria);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
