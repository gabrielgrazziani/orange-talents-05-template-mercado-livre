package br.com.zupacademy.mercado_livre.categoria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

	@PersistenceContext
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastro(@Valid @RequestBody CatadoriaForm form) {
		Categoria categoria = form.map(entityManager);
		entityManager.persist(categoria);
		return ResponseEntity.ok().build();
	}

}
