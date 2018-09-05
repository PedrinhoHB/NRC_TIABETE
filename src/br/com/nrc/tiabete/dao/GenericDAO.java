package br.com.nrc.tiabete.dao;

import java.util.List;

import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.exception.KeyNotFoundException;

public interface GenericDAO<T, K> {

	void inserir(T entidade);

	void atualizar(T entidade);

	void remover(K codigo) throws KeyNotFoundException;

	void removerPorEntidade(T entidade);

	T pesquisar(K codigo);

	List<T> listar();

	void commit() throws CommitException;

}
