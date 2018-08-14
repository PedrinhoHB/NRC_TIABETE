package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.RemedioDAO;
import br.com.nrc.tiabete.dao.impl.RemedioDAOImpl;
import br.com.nrc.tiabete.entity.Remedio;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class RemedioBO {
	private RemedioDAO dao;

	public RemedioBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new RemedioDAOImpl(em);
	}

	public List<Remedio> listar() {
		return dao.listar();
	}

	public Remedio pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(Remedio remedio) throws CommitException {
		dao.inserir(remedio);
		dao.commit();
	}

	public void atualizar(Remedio remedio, int codigo) throws CommitException {
		remedio.setCodigo(codigo);
		dao.atualizar(remedio);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
