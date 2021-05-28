package br.com.zupacademy.mercado_livre.produto.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zupacademy.mercado_livre.usuario.Usuario;

@Entity
public class OpiniaoProduto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Min(1)
	@Max(5) 
	private Integer nota;
	@NotBlank
	private  String titulo;
	@NotBlank
	@Size(max = 500) 
	private String descricao;
	@NotNull
	@ManyToOne
	private Produto produto;
	@NotNull
	@ManyToOne
	private Usuario usuarioQueOpinou;

	public OpiniaoProduto(@NotNull @Min(1) @Max(5) Integer nota, @NotBlank String titulo,
			@NotBlank @Size(max = 500) String descricao,@NotNull Produto produto,@NotNull Usuario usuarioQueOpinou) {
				this.nota = nota;
				this.titulo = titulo;
				this.descricao = descricao;
				this.produto = produto;
				this.usuarioQueOpinou = usuarioQueOpinou;
	}

	@SuppressWarnings("unused")
	@Deprecated
	private OpiniaoProduto() {
	}
}
