package br.com.zupacademy.mercado_livre.produto.controller;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.mercado_livre.confg.security.UsuarioLogado;
import br.com.zupacademy.mercado_livre.generic.UploadImage;
import br.com.zupacademy.mercado_livre.produto.dto.NovasImagensRequest;
import br.com.zupacademy.mercado_livre.produto.entity.ImagemProduto;
import br.com.zupacademy.mercado_livre.produto.entity.Produto;

@RestController
@RequestMapping("produto")
public class AdicionarImagemController {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private UploadImage uploadImage;
	
	@PostMapping("/{idProduto}/imagem")
	@Transactional
	public ResponseEntity<?> adicionaImagem(@Valid NovasImagensRequest request,@PathVariable Long idProduto,@AuthenticationPrincipal UsuarioLogado usuarioLogado){
		Produto produto = entityManager.find(Produto.class, idProduto);
		
		if(!produto.pertenceAo(usuarioLogado.get())){
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		List<URI> urls = uploadImage.envia(request.getImagens());	
		for(URI url : urls) {
			ImagemProduto imagem = new ImagemProduto(url, produto);
			entityManager.persist(imagem);
		}
		return ResponseEntity.ok().body(urls);
	}
}
