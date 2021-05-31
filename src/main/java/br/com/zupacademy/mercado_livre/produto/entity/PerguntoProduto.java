package br.com.zupacademy.mercado_livre.produto.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.mercado_livre.usuario.Usuario;

@Entity
public class PerguntoProduto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private  String titulo;
	@NotNull
	private LocalDateTime instanteCriacao;
	@NotNull
	@ManyToOne
	private Produto produto;
	@NotNull
	@ManyToOne	
	private Usuario consumidor;

	public PerguntoProduto(@NotBlank String titulo,@NotNull Produto produto,@NotNull Usuario consumidor) {
		this.titulo = titulo;
		this.produto = produto;
		this.consumidor = consumidor;
		instanteCriacao = LocalDateTime.now();
	}
	
	public Usuario getConsumidor() {
		return consumidor;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public String getTitulo() {
		return titulo;
	}

}
