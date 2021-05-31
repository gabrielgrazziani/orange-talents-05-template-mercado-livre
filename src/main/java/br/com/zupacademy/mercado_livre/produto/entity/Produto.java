package br.com.zupacademy.mercado_livre.produto.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import br.com.zupacademy.mercado_livre.categoria.Categoria;
import br.com.zupacademy.mercado_livre.usuario.Usuario;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	@NotNull 
	@Positive
	private  BigDecimal valor;
	@NotNull
	@PositiveOrZero
	private Integer quantidade;
	@NotNull 
	@Size(min = 3)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "produto_id")
	private Set<CaracteristicaProduto> caracteristicas;
	@NotBlank
	@Size(max = 1000)
	private String descricao;
	@NotNull
	@ManyToOne
	private Categoria categoria;
	@NotNull
	@ManyToOne	
	private  Usuario dono;
	@NotNull
	@PastOrPresent
	private LocalDateTime instanteCadastro;

	@JsonCreator(mode = Mode.PROPERTIES)
	public Produto(@NotBlank String nome, 
			@NotNull @Positive BigDecimal valor,
			@NotBlank @PositiveOrZero Integer quantidade,
			@NotNull @Size(min = 3) Set<CaracteristicaProduto> caracteristicas,
			@NotNull @Size(max = 1000) String descricao,
			@NotNull Categoria categoria,
			@NotNull Usuario dono) {
				this.nome = nome;
				this.valor = valor;
				this.quantidade = quantidade;
				this.caracteristicas = caracteristicas;
				this.descricao = descricao;
				this.categoria = categoria;
				this.dono = dono;
				this.instanteCadastro = LocalDateTime.now();
	}
	
	@Deprecated
	@SuppressWarnings("unused")
	private Produto() {
	}
	
	public boolean pertenceAo(Usuario usuario){
		return dono.equals(usuario);
	}
	
	public String getNome() {
		return nome;
	}

}
