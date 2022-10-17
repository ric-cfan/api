package org.serratec.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.serratec.domain.Autor;
import org.serratec.domain.Livro;

import io.swagger.annotations.ApiModelProperty;

public class LivroDTO {
	@ApiModelProperty(value="Identificador unico do livro")
	private Long id;

	@ApiModelProperty(value="Titulo do livro")
	private String titulo;

	@ApiModelProperty(value="ISBN do livro")
	private String isbn;

	@ApiModelProperty(value="Data de publicação do livro")
	private Date dataPublicacao;

	@ApiModelProperty(value="Categoria do livro")
	private String nomeCategoria;

	@ApiModelProperty(value="Lista com o nome dos autores do livro")
	private List<String> nomeAutores;

	public LivroDTO() {
		super();
	}

	public LivroDTO(Long id, String titulo, String isbn, Date dataPublicacao, String nomeCategoria,
			List<String> nomeAutores) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.nomeCategoria = nomeCategoria;
		this.nomeAutores = nomeAutores;
	}

	public LivroDTO(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.nomeCategoria = livro.getCategoria().getNome();
		List<Autor> autores = livro.getAutores();
		List<String> nomes = new ArrayList<>();
		for (Autor autor : autores) {
			nomes.add(autor.getNome());
		}
		this.nomeAutores = nomes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public List<String> getNomeAutores() {
		return nomeAutores;
	}

	public void setNomeAutores(List<String> nomeAutores) {
		this.nomeAutores = nomeAutores;
	}

}
