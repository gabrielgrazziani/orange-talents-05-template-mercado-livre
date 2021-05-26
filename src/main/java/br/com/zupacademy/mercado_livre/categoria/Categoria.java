package br.com.zupacademy.mercado_livre.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	@NotBlank
	private String nome;
	@ManyToOne
	private Categoria categoriaMae;
	
	@SuppressWarnings("unused")
	@Deprecated
	private Categoria() {
	}

	public Categoria(@NotNull String nome) {
		this.nome = nome;
	}

	public Categoria(@NotNull String nome, Categoria categoriaMae) {
		this.nome = nome;
		this.categoriaMae = categoriaMae;
	}
}
