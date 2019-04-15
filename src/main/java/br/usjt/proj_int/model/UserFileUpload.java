package br.usjt.proj_int.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class UserFileUpload {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private byte[] arquivoTexto;
	private byte[] imagem;
	private byte[] video;
	private String tag;
	private String categoria;
	private String tipoDeAcesso;
	
	
	
	private enum tipoDeAcesso {
			materialPublico,
			necessarioCadastro
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public byte[] getArquivoTexto() {
		return arquivoTexto;
	}
	public void setArquivoTexto(byte[] bs) {
		this.arquivoTexto = bs;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categorias) {
		this.categoria = categorias;
	}
	public String getTipoDeAcesso() {
		return tipoDeAcesso;
	}
	public void setTipoDeAcesso(String tipoDeAcesso) {
		this.tipoDeAcesso = tipoDeAcesso;
	}
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	public byte[] getVideo() {
		return video;
	}
	public void setVideo(byte[] video) {
		this.video = video;
	}		
}

