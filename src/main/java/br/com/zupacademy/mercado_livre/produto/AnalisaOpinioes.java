package br.com.zupacademy.mercado_livre.produto;

import java.util.List;

import br.com.zupacademy.mercado_livre.produto.entity.OpiniaoProduto;

public class AnalisaOpinioes {

	private List<OpiniaoProduto> opinioes;

	public AnalisaOpinioes(List<OpiniaoProduto> opinioes) {
		this.opinioes = opinioes;
	}

	public float mediaDeNotas() {
		if(opinioes.size() == 0) return 0;
		
		float soma = 0;
		for(OpiniaoProduto opiniao: opinioes) {
			soma += opiniao.getNota();
		}
		return (soma / opinioes.size());
	}

}
