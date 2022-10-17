package org.serratec.dto;

import java.util.List;

import org.serratec.domain.Autor;
import org.serratec.domain.Livro;

import io.swagger.annotations.ApiModelProperty;

public class AutorCountDTO {
	@ApiModelProperty(value="Identificador unico do autor")
	private Long id;
	
	@ApiModelProperty(value="Nome do autor")
	private String nome;

	@ApiModelProperty(value="Quantidade de livros do autor")
	private Integer quantLivros;

	public AutorCountDTO() {
		super();
	}

	public AutorCountDTO(Long id, String nome, Integer quantLivros) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantLivros = quantLivros;
	}

	public AutorCountDTO(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		List<Livro> livros = autor.getLivros();
		Integer count = 0;
		for(int i=0; i<livros.size(); i++) {
			count++;
		}
		this.quantLivros = count;
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

	public Integer getQuantLivros() {
		return quantLivros;
	}

	public void setQuantLivros(Integer quantLivros) {
		this.quantLivros = quantLivros;
	}

}