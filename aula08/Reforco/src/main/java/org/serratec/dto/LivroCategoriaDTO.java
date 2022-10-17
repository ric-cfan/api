package org.serratec.dto;

import org.serratec.domain.Livro;

import io.swagger.annotations.ApiModelProperty;

public class LivroCategoriaDTO {
	@ApiModelProperty(value="Titulo do livro")
	private String tituloLivro;

	@ApiModelProperty(value="Categoria do livro")
	private String nomeCategoria;

	public LivroCategoriaDTO() {
		super();
	}

	public LivroCategoriaDTO(String tituloLivro, String nomeCategoria) {
		super();
		this.tituloLivro = tituloLivro;
		this.nomeCategoria = nomeCategoria;
	}

	public LivroCategoriaDTO(Livro livro) {
		this.tituloLivro = livro.getTitulo();
		this.nomeCategoria = livro.getCategoria().getNome();

	}

	public String getTituloLivro() {
		return tituloLivro;
	}

	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

}
