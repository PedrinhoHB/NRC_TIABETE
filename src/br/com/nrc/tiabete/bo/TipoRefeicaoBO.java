package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.TipoRefeicaoDAO;
import br.com.nrc.tiabete.dao.impl.TipoRefeicaoDAOImpl;
import br.com.nrc.tiabete.entity.TipoRefeicao;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class TipoRefeicaoBO {
	private TipoRefeicaoDAO dao;

	public TipoRefeicaoBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new TipoRefeicaoDAOImpl(em);
	}

	public List<TipoRefeicao> listar() {
		return dao.listar();
	}

	public TipoRefeicao pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(TipoRefeicao tipoRefei) throws CommitException {
		dao.inserir(tipoRefei);
		dao.commit();
	}

	public void atualizar(TipoRefeicao tipoRefei, int codigo) throws CommitException {
		tipoRefei.setCodigo(codigo);
		dao.atualizar(tipoRefei);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
