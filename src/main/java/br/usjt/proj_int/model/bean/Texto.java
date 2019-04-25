package br.usjt.proj_int.model.bean;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Table(name = "tb_texto")
public class Texto extends Material {

	private String direitoDeUso;
	private String autor;
	private String resumo;

	public Texto() {

		super();
	}

	public Texto(Long id, String nome, String url, String autor, String direitoDeUso, String resumo) {

		super(id, nome, url);

		this.autor = autor;
		this.direitoDeUso = direitoDeUso;
		this.resumo = resumo;

	}

	public String getDireitoDeUso() {
		return direitoDeUso;
	}

	public void setDireitoDeUso(String direitoDeUso) {
		this.direitoDeUso = direitoDeUso;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

}
