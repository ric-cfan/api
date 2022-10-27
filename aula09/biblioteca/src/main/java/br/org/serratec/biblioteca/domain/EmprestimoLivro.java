package br.org.serratec.biblioteca.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="emprestimo_livro")
public class EmprestimoLivro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@NotNull
	@JoinColumn(name="id_livro")
	private Livro livro;
	
	@Column(name="obs_ato_emprestimo", length=200)
	private String obsAtoEmprestimo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String getObsAtoEmprestimo() {
		return obsAtoEmprestimo;
	}

	public void setObsAtoEmprestimo(String obsAtoEmprestimo) {
		this.obsAtoEmprestimo = obsAtoEmprestimo;
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
		EmprestimoLivro other = (EmprestimoLivro) obj;
		return Objects.equals(id, other.id);
	}
	

}
