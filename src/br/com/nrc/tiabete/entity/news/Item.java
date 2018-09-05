package br.com.nrc.tiabete.entity.news;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Item")
@Table(name = "T_NRC_NW_ITEM")
@SequenceGenerator(name = "item", sequenceName = "SQ_T_NRC_NW_ITEM")
public class Item {
	@Id
	@Column(name = "cd_item")
	private int codigo;

	@ManyToMany(mappedBy = "itens", cascade = CascadeType.ALL)
	private List<Noticia> noticias;

	@Column(name = "ds_titulo")
	private String titulo;

	@Column(name = "dt_publicacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataPublicacao;

	@Column(name = "ds_link")
	private String link;

	@Column(name = "ds_guid")
	private String guid;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_autor")
	private Autor autor;

	@Column(name = "ds_thumbnail")
	private String thumbnail;

	@Column(name = "ds_noticia")
	private String descricao;

	@Column(name = "ds_content")
	private String content;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_eclosure")
	private Enclosure eclosure;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "T_NRC_NW_ITEM_CAT", joinColumns = { @JoinColumn(name = "cd_item") }, inverseJoinColumns = {
			@JoinColumn(name = "cd_categoria") })
	private List<Categoria> categorias;

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Calendar getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Calendar dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Enclosure getEclosure() {
		return eclosure;
	}

	public void setEclosure(Enclosure eclosure) {
		this.eclosure = eclosure;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
}
