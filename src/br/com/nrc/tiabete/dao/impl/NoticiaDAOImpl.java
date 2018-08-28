package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.NoticiaDAO;
import br.com.nrc.tiabete.entity.news.Noticia;

public class NoticiaDAOImpl extends GenericDAOImpl<Noticia, Integer> implements NoticiaDAO {

	public NoticiaDAOImpl(EntityManager em) {
		super(em);
	}
}
