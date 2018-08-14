package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.InsulinaDAO;
import br.com.nrc.tiabete.dao.impl.InsulinaDAOImpl;
import br.com.nrc.tiabete.entity.Insulina;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class InsulinaBO {
	private InsulinaDAO dao;

	public InsulinaBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new InsulinaDAOImpl(em);
	}

	public List<Insulina> listar() {
		return dao.listar();
	}

	public Insulina pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(Insulina insulina) throws CommitException {
		dao.inserir(insulina);
		dao.commit();
	}

	public void atualizar(Insulina insulina, int codigo) throws CommitException {
		insulina.setCodigo(codigo);
		dao.atualizar(insulina);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
