package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.TipoInsulinaDAO;
import br.com.nrc.tiabete.dao.impl.TipoInsulinaDAOImpl;
import br.com.nrc.tiabete.entity.TipoInsulina;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class TipoInsulinaBO {
	private TipoInsulinaDAO dao;

	public TipoInsulinaBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new TipoInsulinaDAOImpl(em);
	}

	public List<TipoInsulina> listar() {
		return dao.listar();
	}

	public TipoInsulina pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(TipoInsulina tipoInsu) throws CommitException {
		dao.inserir(tipoInsu);
		dao.commit();
	}

	public void atualizar(TipoInsulina tipoInsu, int codigo) throws CommitException {
		tipoInsu.setCodigo(codigo);
		dao.atualizar(tipoInsu);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
