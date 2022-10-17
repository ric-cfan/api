package org.serratec.exercicio02.enums;

import org.serratec.exercicio02.exception.EnumValidationException;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Categoria {
	HATCH, SEDAN, PICAPE, SUV, CONVERSIVEL, MINIVAN;
	
	@JsonCreator
	public static Categoria verifica(String value) throws EnumValidationException {
		for (Categoria categ: Categoria.values()) {
			if(value.equals(categ.name())) {
				return categ;
			}
		}
		throw new EnumValidationException("Categoria " + value + " não existe!");
	}
}
