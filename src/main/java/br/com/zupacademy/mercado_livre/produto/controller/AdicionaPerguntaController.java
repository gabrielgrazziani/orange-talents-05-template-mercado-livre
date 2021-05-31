package br.com.zupacademy.mercado_livre.produto.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.zupacademy.mercado_livre.produto.EnviaEmailPergunta;
import br.com.zupacademy.mercado_livre.produto.dto.PerguntaFrom;
import br.com.zupacademy.mercado_livre.produto.entity.PerguntoProduto;
import br.com.zupacademy.mercado_livre.produto.entity.Produto;

@RestController
@RequestMapping("/produto")
public class AdicionaPerguntaController {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private EnviaEmailPergunta enviaEmailPergunta;
	
	@PostMapping("/{idProduto}/pergunta")
	@Transactional
	public ResponseEntity<?> adiciona(@Valid @RequestBody PerguntaFrom form,@PathVariable Long idProduto,@AuthenticationPrincipal UsuarioLogado usuarioLogado){
		Produto produto = entityManager.find(Produto.class,idProduto);
		if(produto == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Produto não encontrado");
		}
		
		PerguntoProduto pergunto = form.map(produto,usuarioLogado.get());
		entityManager.persist(pergunto);
		
		enviaEmailPergunta.envia(pergunto);
		
		return ResponseEntity.ok().build();
	}
	
}
