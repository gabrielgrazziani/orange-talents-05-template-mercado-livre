package br.com.zupacademy.mercado_livre.produto.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import br.com.zupacademy.mercado_livre.produto.entity.PerguntoProduto;
import br.com.zupacademy.mercado_livre.produto.entity.Produto;
import br.com.zupacademy.mercado_livre.usuario.Usuario;

public class PerguntaFrom {
	
	@NotBlank
	private String titulo;
	
	@JsonCreator(mode = Mode.PROPERTIES)
	public PerguntaFrom(@NotBlank String titulo) {
		this.titulo = titulo;
	}

	public PerguntoProduto map(Produto produto, Usuario consumidor) {
		return new PerguntoProduto(titulo,produto,consumidor);
	}

}
