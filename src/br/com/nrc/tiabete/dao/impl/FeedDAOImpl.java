package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.FeedDAO;
import br.com.nrc.tiabete.entity.news.Feed;

public class FeedDAOImpl extends GenericDAOImpl<Feed, Integer> implements FeedDAO {

	public FeedDAOImpl(EntityManager em) {
		super(em);
	}
}
