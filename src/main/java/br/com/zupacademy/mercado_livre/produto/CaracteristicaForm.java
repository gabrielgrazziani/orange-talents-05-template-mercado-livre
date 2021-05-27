package br.com.zupacademy.mercado_livre.produto;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

public class CaracteristicaForm {

	@NotBlank
	private String nome;
	@NotBlank
	private String descricao;
	
	public CaracteristicaForm(@NotBlank String nome, @NotBlank String descricao) {
		this.nome = nome;
		this.descricao = descricao;
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
		if(obj instanceof CaracteristicaForm) {
			CaracteristicaForm c = (CaracteristicaForm) obj;
			if(nome == null && c.nome == null) {
				return true;
			}
			return nome.equalsIgnoreCase(c.nome);
		}
		return false;
	}

	public static Set<Caracteristica> map(Set<CaracteristicaForm> caracteristicas) {
		return caracteristicas.stream()
			.map(c -> new Caracteristica(c.nome,c.descricao))
			.collect(Collectors.toSet());	
	}
}
