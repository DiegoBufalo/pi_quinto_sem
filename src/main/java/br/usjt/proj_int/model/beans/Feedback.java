package br.usjt.proj_int.model.beans;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.usjt.proj_int.enums.TipoFeedback;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoFeedback feedback;
	
	@ManyToOne
	@JsonIgnoreProperties("feedbacks")
	private Usuario usuario;
	
	@ManyToOne
	@JsonIgnoreProperties("feedbacks")
	private Conteudo conteudo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TipoFeedback getFeedback() {
		return feedback;
	}

	public void setFeedback(TipoFeedback feedback) {
		this.feedback = feedback;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}
}
