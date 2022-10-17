package org.serratec.backend.veiculos.domain;

public class Veiculo {
	private Long id;
	private String marca;
	private String modelo;

	public Veiculo(Long id, String marca, String modelo) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
	}

	public Veiculo() {

	}

	public Long getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

}
