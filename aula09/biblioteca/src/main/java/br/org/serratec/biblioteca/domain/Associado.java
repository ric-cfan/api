package br.org.serratec.biblioteca.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name="associado")
public class Associado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name="nome", nullable=false, length=50)
	private String nome;

	@NotBlank
	@Column(name="telefone", nullable=false, length=15)
	private String telefone;

	@NotBlank
	@CPF
	@Column(name="cpf", nullable=false, length=10)
	private String cpf;
	
	@NotBlank
	@Column(name="logradouro", nullable=false, length=80)
	private String logradouro;

	@NotBlank
	@Column(name="numero", nullable=false, length=10)
	private String numero;

	@Column(name="complemento", length=30)
	private String complemento;
	
	@NotBlank
	@Column(name="bairro", nullable=false, length=50)
	private String bairro;

	@NotBlank
	@Column(name="cidade", nullable=false, length=50)
	private String cidade;
	
	@NotBlank
	@Column(name="estado", nullable=false, length=2)
	private String estado;

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Associado other = (Associado) obj;
		return Objects.equals(id, other.id);
	}

	
}

