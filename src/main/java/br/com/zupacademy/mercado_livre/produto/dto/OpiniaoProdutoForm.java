package br.com.zupacademy.mercado_livre.produto.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.mercado_livre.produto.entity.OpiniaoProduto;
import br.com.zupacademy.mercado_livre.produto.entity.Produto;
import br.com.zupacademy.mercado_livre.usuario.Usuario;

public class OpiniaoProdutoForm {
	
	@NotNull
	@Min(1) @Max(5)
	private Integer nota;
	@NotBlank
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String descricao;
	
	public OpiniaoProdutoForm(@NotNull @Min(1) @Max(5) Integer nota, @NotBlank String titulo,
			@NotBlank @Size(max = 500) String descricao) {
		this.nota = nota;
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public OpiniaoProduto map(Produto produto, Usuario usuarioQueOpinou) {
		return new OpiniaoProduto(nota,titulo,descricao,produto,usuarioQueOpinou);
	}

}
