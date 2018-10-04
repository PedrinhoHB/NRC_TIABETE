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

@Entity(name = "CategoriaInsulina")
@Table(name = "T_NRC_CATEGORIA_INSULINA")
@SequenceGenerator(name = "categoria_insulina", sequenceName = "SQ_T_NRC_CATEGORIA_INSULINA", allocationSize = 1)
public class CategoriaInsulina implements Serializable {

	@Id
	@Column(name = "cd_categoria_insulina")
	@GeneratedValue(generator = "categoria_insulina", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "ds_categoria_insulina", length = 150)
	private String descricao;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
