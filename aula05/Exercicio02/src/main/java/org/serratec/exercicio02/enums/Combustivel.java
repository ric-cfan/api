package org.serratec.exercicio02.enums;

import org.serratec.exercicio02.exception.EnumValidationException;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Combustivel {
	ALCOOL(1, "Álcool"), GASOLINA(2, "Gasolina"), DIESEL(3, "Diesel"), FLEX(4, "Flex");

	private Integer codigo;
	private String tipo;

	private Combustivel(Integer codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getTipo() {
		return tipo;
	}
	
	@JsonCreator
	public static Combustivel verifica(String value) throws EnumValidationException {
		for(Combustivel comb: Combustivel.values()) {
			if (value.equals(comb.name())) {
				return comb;
			}
		}
		throw new EnumValidationException("Combustivel " + value + " não existe!");
	}
}
