package br.usjt.proj_int.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
@Table(name = "tb_conteudo")
public class Conteudo {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=true, length=500)
	private Texto texto;
	
	@Column(nullable=true, length=500)
	private Tag[] tags;
	
	@Column(nullable=true, length=500)
	private Categoria[] categorias;
	
	@Column(nullable=true, length=500)
	private int tipoDeAcesso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Texto getTexto() {
		return texto;
	}

	public void setTexto(Texto texto) {
		this.texto = texto;
	}

	public Tag[] getTags() {
		return tags;
	}

	public void setTags(Tag[] tags) {
		this.tags = tags;
	}

	public Categoria[] getCategorias() {
		return categorias;
	}

	public void setCategorias(Categoria[] categorias) {
		this.categorias = categorias;
	}

	public int getTipoDeAcesso() {
		return tipoDeAcesso;
	}

	public void setTipoDeAcesso(int tipoDeAcesso) {
		this.tipoDeAcesso = tipoDeAcesso;
	}

	@Override
	public String toString() {
		return "Conteudo [id=" + id + ", texto=" + texto + ", tags=" + tags + ", categorias=" + categorias
				+ ", tipoDeAcesso=" + tipoDeAcesso + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categorias == null) ? 0 : categorias.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		result = prime * result + tipoDeAcesso;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conteudo other = (Conteudo) obj;
		if (categorias == null) {
			if (other.categorias != null)
				return false;
		} else if (!categorias.equals(other.categorias))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		if (tipoDeAcesso != other.tipoDeAcesso)
			return false;
		return true;
	}	
}
