package br.com.nrc.tiabete.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.GenericDAO;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	protected EntityManager em;

	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void inserir(T entidade) {
		em.persist(entidade);
	}

	@Override
	public void atualizar(T entidade) {
		em.merge(entidade);
	}

	@Override
	public void remover(K codigo) throws KeyNotFoundException {
		T entidade = pesquisar(codigo);
		if (entidade == null) {
			throw new KeyNotFoundException();
		}
		em.remove(entidade);
	}

	@Override
	public void removerPorEntidade(T entidade) {
		em.remove(entidade);
	}

	@Override
	public T pesquisar(K codigo) {
		return em.find(clazz, codigo);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException("Erro ao gravar");
		}
	}

	@Override
	public List<T> listar() {
		return em.createQuery("from " + clazz.getName(), clazz).getResultList();
	}
}
