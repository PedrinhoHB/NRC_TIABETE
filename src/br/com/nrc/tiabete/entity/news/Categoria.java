package br.com.nrc.tiabete.entity.news;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Categoria")
@Table(name = "T_NRC_NW_CATEGORIA")
@SequenceGenerator(name = "categoria", sequenceName = "SQ_T_NRC_NW_CATEGORIA")
public class Categoria {
	@Id
	@GeneratedValue(generator = "categoria", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Enumerated(EnumType.STRING)
	private Grupo grupo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
}
