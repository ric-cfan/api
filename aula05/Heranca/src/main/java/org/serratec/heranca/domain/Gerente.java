package org.serratec.heranca.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="funcionarios")
public class Gerente extends Funcionario {
	
	@Column(length = 10)
	private String setor;

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	

}
