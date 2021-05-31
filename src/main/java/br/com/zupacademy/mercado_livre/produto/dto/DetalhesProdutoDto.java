package br.com.zupacademy.mercado_livre.produto.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.zupacademy.mercado_livre.produto.entity.ImagemProduto;
import br.com.zupacademy.mercado_livre.produto.entity.OpiniaoProduto;
import br.com.zupacademy.mercado_livre.produto.entity.PerguntoProduto;
import br.com.zupacademy.mercado_livre.produto.entity.Produto;

public class DetalhesProdutoDto {

	private String nome;
	private BigDecimal preco;
	private String descricao;
	private float mediaNotasProduto;
	private int numeroDeNotasProduto;
	private List<String> urlImagens;
	private List<CaracteristicaDto> caracteristicas;
	private List<PeguntasDto> peguntas;
	private List<OpinioesDto> opinioes;
	
	public DetalhesProdutoDto(Produto produto,List<ImagemProduto> imagens,List<PerguntoProduto> peguntas,
			List<OpiniaoProduto> opinioes,float mediaNotasProduto) {
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
		this.descricao = produto.getDescricao();
		this.numeroDeNotasProduto = opinioes.size();
		this.mediaNotasProduto = mediaNotasProduto;
		
		this.urlImagens = imagens
			.stream()
			.map(i -> i.getUrl().toString())
			.collect(Collectors.toList());
		
		this.caracteristicas = produto
				.getCaracteristicas()
				.stream()
				.map(c -> new CaracteristicaDto(c))
				.collect(Collectors.toList());
		
		this.peguntas = peguntas
				.stream()
				.map(c -> new PeguntasDto(c))
				.collect(Collectors.toList());
		
		this.opinioes = opinioes
				.stream()
				.map(o -> new OpinioesDto(o))
				.collect(Collectors.toList());	
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public float getMediaNotasProduto() {
		return mediaNotasProduto;
	}

	public int getNumeroDeNotasProduto() {
		return numeroDeNotasProduto;
	}

	public List<String> getUrlImagens() {
		return urlImagens;
	}

	public List<CaracteristicaDto> getCaracteristicas() {
		return caracteristicas;
	}

	public List<PeguntasDto> getPeguntas() {
		return peguntas;
	}

	public List<OpinioesDto> getOpinioes() {
		return opinioes;
	}
	
}
