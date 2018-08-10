package br.com.nrc.tiabete.dao;

import br.com.nrc.tiabete.entity.Dependente;
import br.com.nrc.tiabete.exception.CommitException;

public interface DependenteDAO extends GenericDAO<Dependente, Integer> {

	public void insereComDtCriacao(Dependente dependente) throws CommitException;

	public void atualizaComDtUltAlteracao(Dependente dependente, int codigo) throws CommitException;
}
