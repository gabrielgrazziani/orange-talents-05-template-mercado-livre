package br.com.zupacademy.mercado_livre.produto.dto;

import br.com.zupacademy.mercado_livre.produto.entity.OpiniaoProduto;

public class OpinioesDto {

	private String descricao;
	private Integer nota;
	private String titulo;
	private String nomeUsuario;

	public OpinioesDto(OpiniaoProduto o) {
		descricao = o.getDescricao();
		nota = o.getNota();
		titulo = o.getTitulo();
		nomeUsuario = o.nomeUsuario();
	}

	public String getDescricao() {
		return descricao;
	}

	public Integer getNota() {
		return nota;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}	
}
