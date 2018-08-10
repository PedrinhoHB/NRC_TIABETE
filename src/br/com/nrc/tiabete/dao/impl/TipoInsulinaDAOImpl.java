package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.TipoInsulinaDAO;
import br.com.nrc.tiabete.entity.TipoInsulina;

public class TipoInsulinaDAOImpl extends GenericDAOImpl<TipoInsulina, Integer> implements TipoInsulinaDAO {

	public TipoInsulinaDAOImpl(EntityManager em) {
		super(em);
	}
}
