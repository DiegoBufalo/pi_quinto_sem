package br.usjt.proj_int.model.bean;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Table(name = "tb_video")
public class Video extends Material {

	private String producao;

	public Video() {

		super();
	}

	public Video(Long id, String nome, String url, String autor, String producao) {

		super(id, nome, url);

		this.producao = producao;
	}

	public String getProducao() {
		return producao;
	}

	public void setProducao(String producao) {
		this.producao = producao;
	}

}
