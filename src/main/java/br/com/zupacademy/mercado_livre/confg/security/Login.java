package br.com.zupacademy.mercado_livre.confg.security;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class Login {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenManager tokenManager;
	
	@PostMapping
	public ResponseEntity<String> login(@Valid @RequestBody LoginForm form) {	
		try {
			Authentication authenticate = authenticationManager.authenticate(form.map());
			String token = tokenManager.gerarToken(authenticate);
			return ResponseEntity.ok(token);
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().body("Dados incorretos");
		}
	}
}
