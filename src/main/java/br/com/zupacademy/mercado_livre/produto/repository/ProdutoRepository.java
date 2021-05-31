package br.com.zupacademy.mercado_livre.produto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.zupacademy.mercado_livre.produto.entity.ImagemProduto;
import br.com.zupacademy.mercado_livre.produto.entity.OpiniaoProduto;
import br.com.zupacademy.mercado_livre.produto.entity.PerguntoProduto;
import br.com.zupacademy.mercado_livre.produto.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	@Query("select p from PerguntoProduto p where p.produto.id = :idProduto")
	List<PerguntoProduto> peguntasDesteProdutoPorId(@Param("idProduto") Long idProduto);


	@Query("select o from OpiniaoProduto o where o.produto.id = :idProduto")
	List<OpiniaoProduto> opinioesDesteProdutoPorId(@Param("idProduto") Long idProduto);

	@Query("select i from ImagemProduto i where i.produto.id = :idProduto")
	List<ImagemProduto> imagensDesteProdutoPorId(@Param("idProduto") Long idProduto);
}
