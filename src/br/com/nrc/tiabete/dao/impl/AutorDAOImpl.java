package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.AutorDAO;
import br.com.nrc.tiabete.entity.news.Autor;

public class AutorDAOImpl extends GenericDAOImpl<Autor, Integer> implements AutorDAO {

	public AutorDAOImpl(EntityManager em) {
		super(em);
	}
}
