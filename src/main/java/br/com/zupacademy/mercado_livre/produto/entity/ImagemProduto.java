package br.com.zupacademy.mercado_livre.produto.entity;

import java.net.URI;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class ImagemProduto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private URI url;
	@NotNull
	@ManyToOne
	private Produto produto;
	
	@SuppressWarnings("unused")
	@Deprecated
	private ImagemProduto() {
	}
	
	public ImagemProduto(@NotNull URI url, @NotNull Produto produto) {
		this.url = url;
		this.produto = produto;
	}
	
	public URI getUrl() {
		return url;
	}
}
