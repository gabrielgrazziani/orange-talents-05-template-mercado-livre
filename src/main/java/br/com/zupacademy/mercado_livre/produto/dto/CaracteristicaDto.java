package br.com.zupacademy.mercado_livre.produto.dto;

import br.com.zupacademy.mercado_livre.produto.entity.CaracteristicaProduto;

public class CaracteristicaDto {

	private String nome;
	private String descricao;

	public CaracteristicaDto(CaracteristicaProduto c) {
		nome = c.getNome();
		descricao = c.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
