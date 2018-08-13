package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.UsuarioDAO;
import br.com.nrc.tiabete.entity.Usuario;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO {

	public UsuarioDAOImpl(EntityManager em) {
		super(em);
	}
}
