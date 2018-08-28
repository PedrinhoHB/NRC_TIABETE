package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.FeedDAO;
import br.com.nrc.tiabete.dao.impl.FeedDAOImpl;
import br.com.nrc.tiabete.entity.news.Feed;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class FeedBO {
	private FeedDAO dao;

	public FeedBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new FeedDAOImpl(em);
	}

	public List<Feed> listar() {
		return dao.listar();
	}

	public Feed pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(Feed feed) throws CommitException {
		dao.inserir(feed);
		dao.commit();
	}

	public void atualizar(Feed feed, int codigo) throws CommitException {
		feed.setCodigo(codigo);
		dao.atualizar(feed);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
