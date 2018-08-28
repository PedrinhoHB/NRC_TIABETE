package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.AutorDAO;
import br.com.nrc.tiabete.dao.impl.AutorDAOImpl;
import br.com.nrc.tiabete.entity.news.Autor;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class AutorBO {
	private AutorDAO dao;

	public AutorBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new AutorDAOImpl(em);
	}

	public List<Autor> listar() {
		return dao.listar();
	}

	public Autor pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(Autor autor) throws CommitException {
		dao.inserir(autor);
		dao.commit();
	}

	public void atualizar(Autor autor, int codigo) throws CommitException {
		autor.setCodigo(codigo);
		dao.atualizar(autor);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
