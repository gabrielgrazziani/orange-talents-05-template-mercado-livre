package br.com.zupacademy.mercado_livre.produto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Caracteristica {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private @NotBlank String descricao;
	private @NotBlank String nome;

	public Caracteristica(@NotBlank String nome, @NotBlank String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	@Deprecated
	@SuppressWarnings("unused")
	private Caracteristica() {
	}
	
	@Override
	public int hashCode() {
		if(nome == null) {
			return super.hashCode();
		}
		return nome.toUpperCase().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Caracteristica) {
			Caracteristica c = (Caracteristica) obj;
			if(nome == null && c.nome == null) {
				return true;
			}
			return nome.equalsIgnoreCase(c.nome);
		}
		return false;
	}
}
