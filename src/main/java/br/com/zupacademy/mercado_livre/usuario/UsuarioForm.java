package br.com.zupacademy.mercado_livre.usuario;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.password.PasswordEncoder;

public class UsuarioForm {

	@NotBlank
	@Email
	private String login;
	@NotBlank
	@Size(min = 6)
	private String senha;
	
	public UsuarioForm(@NotBlank @Email String login, @NotBlank @Size(min = 6) String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	public Usuario map(PasswordEncoder encoder) {
		return new Usuario(login, encoder.encode(senha), LocalDateTime.now());
	}
}
