package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.ItemDAO;
import br.com.nrc.tiabete.entity.news.Item;

public class ItemDAOImpl extends GenericDAOImpl<Item, Integer> implements ItemDAO {

	public ItemDAOImpl(EntityManager em) {
		super(em);
	}
}
