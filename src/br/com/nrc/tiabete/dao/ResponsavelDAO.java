package br.com.nrc.tiabete.dao;

import java.util.List;

import br.com.nrc.tiabete.entity.Dependente;
import br.com.nrc.tiabete.entity.Responsavel;

public interface ResponsavelDAO extends GenericDAO<Responsavel, Integer> {

	List<Dependente> dependentesPorResponsavel(int idResp);
}
