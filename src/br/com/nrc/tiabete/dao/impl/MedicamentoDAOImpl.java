package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.MedicamentoDAO;
import br.com.nrc.tiabete.entity.Medicamento;

public class MedicamentoDAOImpl extends GenericDAOImpl<Medicamento, Integer> implements MedicamentoDAO {

	public MedicamentoDAOImpl(EntityManager em) {
		super(em);
	}
}
