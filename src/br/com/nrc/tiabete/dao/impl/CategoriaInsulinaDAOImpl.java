package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.CategoriaInsulinaDAO;
import br.com.nrc.tiabete.entity.CategoriaInsulina;

public class CategoriaInsulinaDAOImpl extends GenericDAOImpl<CategoriaInsulina, Integer>
		implements CategoriaInsulinaDAO {

	public CategoriaInsulinaDAOImpl(EntityManager em) {
		super(em);
	}
}
