package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.UsuarioDAO;
import br.com.nrc.tiabete.dao.impl.UsuarioDAOImpl;
import br.com.nrc.tiabete.entity.Usuario;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class UsuarioBO {
	private UsuarioDAO dao;

	public UsuarioBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new UsuarioDAOImpl(em);
	}

	public List<Usuario> listar() {
		return dao.listar();
	}

	public Usuario pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(Usuario usuario) throws CommitException {
		dao.inserir(usuario);
		dao.commit();
	}

	public void atualizar(Usuario usuario, int codigo) throws CommitException {
		usuario.setCodigo(codigo);
		dao.atualizar(usuario);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
