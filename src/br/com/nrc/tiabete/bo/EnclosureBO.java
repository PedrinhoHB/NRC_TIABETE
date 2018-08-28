package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.EnclosureDAO;
import br.com.nrc.tiabete.dao.impl.EnclosureDAOImpl;
import br.com.nrc.tiabete.entity.news.Enclosure;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class EnclosureBO {
	private EnclosureDAO dao;

	public EnclosureBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new EnclosureDAOImpl(em);
	}

	public List<Enclosure> listar() {
		return dao.listar();
	}

	public Enclosure pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(Enclosure enclosure) throws CommitException {
		dao.inserir(enclosure);
		dao.commit();
	}

	public void atualizar(Enclosure enclosure, int codigo) throws CommitException {
		enclosure.setCodigo(codigo);
		dao.atualizar(enclosure);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
