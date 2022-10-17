package org.serratec.dto;

import java.util.ArrayList;
import java.util.List;

import org.serratec.domain.Autor;
import org.serratec.domain.Livro;

import io.swagger.annotations.ApiModelProperty;

public class AutorDTO {
	@ApiModelProperty(value="Identificador unico do autor")
	private Long id;

	@ApiModelProperty(value="Nome do autor")
	private String nome;

	@ApiModelProperty(value="Lista com nomes dos livros do autor")
	private List<String> nomeLivros;

	public AutorDTO() {
		super();
	}

	public AutorDTO(Long id, String nome, List<String> nomeLivros) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeLivros = nomeLivros;
	}

	public AutorDTO(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		List<Livro> livros = autor.getLivros();
		List<String> titulos = new ArrayList<>();
		for (Livro livro : livros) {
			titulos.add(livro.getTitulo());
		}
		this.nomeLivros = titulos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getNomeLivros() {
		return nomeLivros;
	}

	public void setNomeLivros(List<String> nomeLivros) {
		this.nomeLivros = nomeLivros;
	}

}