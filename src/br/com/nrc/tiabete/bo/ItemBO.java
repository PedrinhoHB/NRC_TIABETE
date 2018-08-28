package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.ItemDAO;
import br.com.nrc.tiabete.dao.impl.ItemDAOImpl;
import br.com.nrc.tiabete.entity.news.Item;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class ItemBO {
	private ItemDAO dao;

	public ItemBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new ItemDAOImpl(em);
	}

	public List<Item> listar() {
		return dao.listar();
	}

	public Item pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(Item item) throws CommitException {
		dao.inserir(item);
		dao.commit();
	}

	public void atualizar(Item item, int codigo) throws CommitException {
		item.setCodigo(codigo);
		dao.atualizar(item);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
