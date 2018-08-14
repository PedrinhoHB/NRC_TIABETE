package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.AlimentoDAO;
import br.com.nrc.tiabete.dao.impl.AlimentoDAOImpl;
import br.com.nrc.tiabete.entity.Alimento;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class AlimentoBO {
	private AlimentoDAO dao;

	public AlimentoBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new AlimentoDAOImpl(em);
	}

	public List<Alimento> listar() {
		return dao.listar();
	}

	public Alimento pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(Alimento alimento) throws CommitException {
		dao.inserir(alimento);
		dao.commit();
	}

	public void atualizar(Alimento alimento, int codigo) throws CommitException {
		alimento.setCodigo(codigo);
		dao.atualizar(alimento);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
