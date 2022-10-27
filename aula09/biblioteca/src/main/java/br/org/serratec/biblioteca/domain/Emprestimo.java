package br.org.serratec.biblioteca.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="emprestimo")
public class Emprestimo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_associado", nullable = false)
	private Associado associado;
	
	@Column(name="data_emprestimo")
	private LocalDate dataEmprestimo;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_emprestimo")
	private List<EmprestimoLivro> emprestimoLivro;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Associado getAssociado() {
		return associado;
	}


	public void setAssociado(Associado associado) {
		this.associado = associado;
	}


	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}


	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}


	public List<EmprestimoLivro> getEmprestimoLivro() {
		return emprestimoLivro;
	}


	public void setEmprestimoLivro(List<EmprestimoLivro> emprestimoLivro) {
		this.emprestimoLivro = emprestimoLivro;
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
		Emprestimo other = (Emprestimo) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
