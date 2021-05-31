package br.com.zupacademy.mercado_livre.produto.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mercado_livre.produto.AnalisaOpinioes;
import br.com.zupacademy.mercado_livre.produto.dto.DetalhesProdutoDto;
import br.com.zupacademy.mercado_livre.produto.entity.ImagemProduto;
import br.com.zupacademy.mercado_livre.produto.entity.OpiniaoProduto;
import br.com.zupacademy.mercado_livre.produto.entity.PerguntoProduto;
import br.com.zupacademy.mercado_livre.produto.entity.Produto;
import br.com.zupacademy.mercado_livre.produto.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class DetalhesProdutoController {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/{idProduto}")
	public ResponseEntity<?> buscaDetalhesProduto(@PathVariable Long idProduto) {
		Produto produto = entityManager.find(Produto.class, idProduto);
		
		if(produto == null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		List<PerguntoProduto> perguntas =  produtoRepository.peguntasDesteProdutoPorId(idProduto);
		
		List<OpiniaoProduto> opinioes = produtoRepository.opinioesDesteProdutoPorId(idProduto);
		
		List<ImagemProduto> imagens = produtoRepository.imagensDesteProdutoPorId(idProduto);
		
		AnalisaOpinioes analisador = new AnalisaOpinioes(opinioes);
		float mediaDeNotas = analisador.mediaDeNotas();
		
		return ResponseEntity.ok(new DetalhesProdutoDto(produto, imagens, perguntas, opinioes, mediaDeNotas));
	}
	
}
