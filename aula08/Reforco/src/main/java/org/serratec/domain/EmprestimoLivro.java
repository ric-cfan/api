package org.serratec.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="emprestimo_livro")
public class EmprestimoLivro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_emprestimo_livro")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_emprestimo")
	private Emprestimo emprestimo;
	
	@ManyToOne
	@JoinColumn(name = "id_livro")
	private Livro livro;

	@Size(max = 200)
	private String observacoesAtoEmprestimo;
}
