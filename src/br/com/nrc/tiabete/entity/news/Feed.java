package br.com.nrc.tiabete.entity.news;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Feed")
@Table(name = "T_NRC_NW_FEED")
@SequenceGenerator(name = "feed", sequenceName = "SQ_T_NRC_NW_FEED", initialValue = 1, allocationSize = 1)
public class Feed {
	@Id
	@GeneratedValue(generator = "feed", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "ds_url")
	private String url;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "ds_link")
	private String link;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_autor")
	private Autor autor;

	@Column(name = "ds_feed")
	private String descricao;

	@Column(name = "ds_link_imagem")
	private String imagem;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

}
