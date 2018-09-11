package br.com.nrc.tiabete.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")

@Entity(name = "Remedio")
@Table(name = "T_NRC_REMEDIO")
@SequenceGenerator(name = "remedio", sequenceName = "SQ_T_NRC_REMEDIO", allocationSize = 1)
public class Remedio implements Serializable {
	@Id
	@Column(name = "cd_remedio")
	@GeneratedValue(generator = "remedio", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "nm_remedio")
	private String nome;

	@Column(name = "ds_tipo")
	private String tipo;

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
