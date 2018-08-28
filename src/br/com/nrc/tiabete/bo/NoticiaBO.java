package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.NoticiaDAO;
import br.com.nrc.tiabete.dao.impl.NoticiaDAOImpl;
import br.com.nrc.tiabete.entity.news.Noticia;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class NoticiaBO {
	private NoticiaDAO dao;

	public NoticiaBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new NoticiaDAOImpl(em);
	}

	public List<Noticia> listar() {
		return dao.listar();
	}

	public Noticia pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(Noticia noticia) throws CommitException {
		dao.inserir(noticia);
		dao.commit();
	}

	public void atualizar(Noticia noticia, int codigo) throws CommitException {
		noticia.setCodigo(codigo);
		dao.atualizar(noticia);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
