package br.com.nrc.tiabete.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.MedicamentoDAO;
import br.com.nrc.tiabete.dao.impl.MedicamentoDAOImpl;
import br.com.nrc.tiabete.entity.Medicamento;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class MedicamentoBO {
	private MedicamentoDAO dao;

	public MedicamentoBO() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new MedicamentoDAOImpl(em);
	}

	public List<Medicamento> listar() {
		return dao.listar();
	}

	public Medicamento pesquisar(int codigo) {
		return dao.pesquisar(codigo);
	}

	public void inserir(Medicamento medicamento) throws CommitException {
		dao.inserir(medicamento);
		dao.commit();
	}

	public void atualizar(Medicamento medicamento, int codigo) throws CommitException {
		medicamento.setCodigo(codigo);
		dao.atualizar(medicamento);
		dao.commit();
	}

	public void remover(int codigo) throws CommitException, KeyNotFoundException {
		dao.remover(codigo);
		dao.commit();
	}

}
