package org.serratec.backend.exercicio01.domain;

public class Aluno {
	private Long matricula;
	private String nome, telefone;

	public Aluno(Long matricula, String nome, String telefone) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.telefone = telefone;
	}

	public Aluno() {
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}