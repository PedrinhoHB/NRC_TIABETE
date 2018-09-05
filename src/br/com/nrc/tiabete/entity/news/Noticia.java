package br.com.nrc.tiabete.entity.news;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Noticia")
@Table(name = "T_NRC_NW_NOTICIA")
@SequenceGenerator(name = "noticia", sequenceName = "SQ_T_NRC_NW_NOTICIA", allocationSize = 1)
public class Noticia {
	@Id
	@GeneratedValue(generator = "noticia")
	@Column(name = "cd_noticia")
	private int codigo;

	@Column(name = "ds_status")
	private boolean status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_feed")
	private Feed feed;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "T_NRC_NW_NOTI_ITEM", joinColumns = { @JoinColumn(name = "cd_noticia") }, inverseJoinColumns = {
			@JoinColumn(name = "cd_item") })
	private List<Item> itens;

	public Noticia() {
		itens = new ArrayList<Item>();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Feed getFeed() {
		return feed;
	}

	public void setFeed(Feed feed) {
		this.feed = feed;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
}
