package br.com.zupacademy.mercado_livre.produto.dto;

import br.com.zupacademy.mercado_livre.produto.entity.PerguntoProduto;

public class PeguntasDto {

	private String nomeConsumidor;
	private String titulo;

	public PeguntasDto(PerguntoProduto c) {
		titulo = c.getTitulo();
		nomeConsumidor = c.nomeConsumidor();
	}

	public String getNomeConsumidor() {
		return nomeConsumidor;
	}

	public String getTitulo() {
		return titulo;
	}

}
