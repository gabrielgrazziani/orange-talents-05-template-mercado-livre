package br.com.zupacademy.mercado_livre.categoria;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.mercado_livre.generic.ExistById;
import br.com.zupacademy.mercado_livre.generic.UniqueValue;

public class CatadoriaForm {

	@NotBlank
	@UniqueValue(domainClass = Categoria.class,fieldName = "nome")
	private String nome;
	@ExistById(domainClass = Categoria.class)
	private Long idCategoriaMae;
	
	public CatadoriaForm(@NotBlank String nome, @NotNull Long idCategoriaMae) {
		this.nome = nome;
		this.idCategoriaMae = idCategoriaMae;
	}
	
	public Categoria map(EntityManager entityManager) {
		if(idCategoriaMae == null) {
			return new Categoria(nome);
		}
		Categoria categoria = entityManager.find(Categoria.class, idCategoriaMae);
		return new Categoria(nome,categoria);
	}
}
