package br.com.zupacademy.mercado_livre.produto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mercado_livre.confg.security.UsuarioLogado;

@RestController
@RequestMapping("/produto")
public class CadastroProdutoController {
	
	@PersistenceContext
	private EntityManager entityManager;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastro(@Valid @RequestBody ProdutoForm form,@AuthenticationPrincipal UsuarioLogado usuarioLogado){
		Produto produto = form.map(entityManager,usuarioLogado.get());
		entityManager.persist(produto);
		return ResponseEntity.ok().build();
	}
}
