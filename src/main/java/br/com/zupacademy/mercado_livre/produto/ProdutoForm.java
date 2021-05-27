package br.com.zupacademy.mercado_livre.produto;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import br.com.zupacademy.mercado_livre.categoria.Categoria;
import br.com.zupacademy.mercado_livre.generic.ExistById;
import br.com.zupacademy.mercado_livre.usuario.Usuario;

public class ProdutoForm {
	@NotBlank
	private String nome;
	@NotNull
	@Positive
	private BigDecimal valor;
	@NotNull
	@PositiveOrZero
	private Integer quantidade;
	@NotNull
	@Size(min = 3)
	private Set<CaracteristicaForm> caracteristicas;
	@NotBlank
	@Size(max = 1000)
	private String descricao;
	@NotNull
	@ExistById(domainClass = Categoria.class)
	private Long categoriaId;
	
	public ProdutoForm(@NotBlank String nome, @NotNull @Positive BigDecimal valor,
			@NotBlank @PositiveOrZero Integer quantidade,
			@NotNull @Size(min = 3) Set<CaracteristicaForm> caracteristicas,
			@NotNull @Size(max = 1000) String descricao, @NotNull Long categoriaId) {
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
		this.caracteristicas = caracteristicas;
		this.descricao = descricao;
		this.categoriaId = categoriaId;
	}

	public Produto map(EntityManager entityManager, Usuario usuario) {
		Categoria categoria = entityManager.find(Categoria.class, categoriaId);
		Set<Caracteristica> caracteristicas = CaracteristicaForm.map(this.caracteristicas);
		return new Produto(nome,valor,quantidade,caracteristicas,descricao,categoria,usuario);
	}
	
}
