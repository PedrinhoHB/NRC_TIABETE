package br.com.nrc.tiabete.entity.news;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Autor")
@Table(name = "T_NRC_NW_AUTOR")
@SequenceGenerator(name = "autor", sequenceName = "SQ_T_NRC_NW_AUTOR", initialValue = 1, allocationSize = 1)
public class Autor {
	@Id
	@Column(name = "cd_autor")
	private int codigo;

	@Column(name = "nm_autor")
	private String nome;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
