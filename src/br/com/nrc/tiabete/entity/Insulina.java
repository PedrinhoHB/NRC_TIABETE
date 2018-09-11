package br.com.nrc.tiabete.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")

@Entity(name = "Insulina")
@Table(name = "T_NRC_INSU")
@SequenceGenerator(name = "insulina", sequenceName = "SQ_T_NRC_INSULINA", allocationSize = 1)
public class Insulina implements Serializable {

	@Id
	@Column(name = "cd_insulina")
	@GeneratedValue(generator = "insulina", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_tipo_insulina")
	private TipoInsulina tipoInsulina;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_categoria_insulina")
	private CategoriaInsulina categoriaInsulina;

	@Column(name = "nm_insulina", length = 150)
	private String nome;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public TipoInsulina getTipoInsulina() {
		return tipoInsulina;
	}

	public void setTipoInsulina(TipoInsulina tipoInsulina) {
		this.tipoInsulina = tipoInsulina;
	}

	public CategoriaInsulina getCategoriaInsulina() {
		return categoriaInsulina;
	}

	public void setCategoriaInsulina(CategoriaInsulina categoriaInsulina) {
		this.categoriaInsulina = categoriaInsulina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
