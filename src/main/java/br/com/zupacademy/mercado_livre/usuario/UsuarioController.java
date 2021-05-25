package br.com.zupacademy.mercado_livre.usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private PasswordEncoder encoder;
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastro(@Valid @RequestBody UsuarioForm form) {
		Usuario usuario = form.map(encoder);
		entityManager.persist(usuario);
		return ResponseEntity.ok().build();
	}
}
