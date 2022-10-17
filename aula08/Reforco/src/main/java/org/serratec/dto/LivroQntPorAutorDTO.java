package org.serratec.dto;

import org.serratec.domain.Livro;

import io.swagger.annotations.ApiModelProperty;

public class LivroQntPorAutorDTO {
	@ApiModelProperty(value="Identificador unico do autor")
	private Long id;

	@ApiModelProperty(value="Nome do autor livro")
	private String nome;

	@ApiModelProperty(value="Quantidade de livros do autor")
	private Integer qntLivros;


	public LivroQntPorAutorDTO(Long id, String nome, Integer qntLivros) {
		super();
		this.id = id;
		this.nome = nome;
		this.qntLivros = qntLivros;
	}
	
	public LivroQntPorAutorDTO(Livro livro) {
		super();
	}

	public LivroQntPorAutorDTO() {
		super();
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

	public Integer getQntLivros() {
		return qntLivros;
	}

	public void setQntLivros(Integer qntLivros) {
		this.qntLivros = qntLivros;
	}

}