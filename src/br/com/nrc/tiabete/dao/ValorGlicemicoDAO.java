package br.com.nrc.tiabete.dao;

import java.util.Collection;

import br.com.nrc.tiabete.entity.ValorGlicemico;

public interface ValorGlicemicoDAO extends GenericDAO<ValorGlicemico, Integer> {

	Collection<Object[]> mediaGlicemicaSemanal(int codigo);
}
