package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.CategoriaDAO;
import br.com.nrc.tiabete.entity.news.Categoria;

public class CategoriaDAOImpl extends GenericDAOImpl<Categoria, Integer> implements CategoriaDAO {

	public CategoriaDAOImpl(EntityManager em) {
		super(em);
	}
}
