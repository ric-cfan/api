package org.serratec.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "emprestimo")
public class Emprestimo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_emprestimo")
	private Long id;

	@NotBlank
	private Date dataEmprstimo;

	@ManyToOne
	@JoinColumn(name = "id_associado")
	private Associado associado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataEmprstimo() {
		return dataEmprstimo;
	}

	public void setDataEmprstimo(Date dataEmprstimo) {
		this.dataEmprstimo = dataEmprstimo;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

}
