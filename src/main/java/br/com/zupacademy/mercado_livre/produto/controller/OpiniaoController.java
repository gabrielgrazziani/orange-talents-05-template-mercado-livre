package br.com.zupacademy.mercado_livre.produto.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.zupacademy.mercado_livre.confg.security.UsuarioLogado;
import br.com.zupacademy.mercado_livre.produto.dto.OpiniaoProdutoForm;
import br.com.zupacademy.mercado_livre.produto.entity.OpiniaoProduto;
import br.com.zupacademy.mercado_livre.produto.entity.Produto;

@RestController
@RequestMapping("/produto")
public class OpiniaoController {
	
	@PersistenceContext
	private EntityManager entityManager;

	@PostMapping("/{idProduto}/opiniao")
	@Transactional
	public ResponseEntity<?> criar(@Valid @RequestBody OpiniaoProdutoForm opiniaoForm, @PathVariable Long idProduto,
			@AuthenticationPrincipal UsuarioLogado usuarioLogado) {
		
		Produto produto = entityManager.find(Produto.class, idProduto);
		if(produto == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Não existe produto com este id");
		}
		
		OpiniaoProduto opiniao = opiniaoForm.map(produto,usuarioLogado.get());
		
		entityManager.persist(opiniao);
		return ResponseEntity.ok().build();
	}

}
