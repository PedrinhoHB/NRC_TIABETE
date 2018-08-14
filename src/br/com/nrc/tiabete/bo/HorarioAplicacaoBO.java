package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.HorarioAplicacaoDAO;
import br.com.nrc.tiabete.dao.impl.HorarioAplicacaoDAOImpl;
import br.com.nrc.tiabete.entity.HorarioAplicacao;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class HorarioAplicacaoBO {
	private HorarioAplicacaoDAO dao;

	public HorarioAplicacaoBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new HorarioAplicacaoDAOImpl(em);
	}

	public List<HorarioAplicacao> listar() {
		return dao.listar();
	}

	public HorarioAplicacao pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(HorarioAplicacao horaApli) throws CommitException {
		dao.inserir(horaApli);
		dao.commit();
	}

	public void atualizar(HorarioAplicacao horaApli, int codigo) throws CommitException {
		horaApli.setCodigo(codigo);
		dao.atualizar(horaApli);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}
}
