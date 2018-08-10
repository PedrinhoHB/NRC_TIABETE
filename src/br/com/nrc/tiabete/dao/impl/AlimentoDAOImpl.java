package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.AlimentoDAO;
import br.com.nrc.tiabete.entity.Alimento;

public class AlimentoDAOImpl extends GenericDAOImpl<Alimento, Integer> implements AlimentoDAO {

	public AlimentoDAOImpl(EntityManager em) {
		super(em);
	}
}
