package br.usjt.proj_int.model.dto;

import br.usjt.proj_int.model.beans.Categoria;

public class CategoriaUploadDTO {

	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	private String nome;
	
	public CategoriaUploadDTO (Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
	}
}
