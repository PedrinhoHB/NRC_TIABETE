package br.com.nrc.tiabete.entity.news;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Enclosure")
@Table(name = "T_NRC_NW_ENCLOSURE")
@SequenceGenerator(name = "enclosure", sequenceName = "SQ_T_NRC_NW_ENCLOSURE")
public class Enclosure {
	@Id
	@GeneratedValue(generator = "enclosure", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "ds_link")
	private String link;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
