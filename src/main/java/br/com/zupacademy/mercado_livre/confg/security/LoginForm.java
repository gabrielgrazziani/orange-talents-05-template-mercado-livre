package br.com.zupacademy.mercado_livre.confg.security;

import javax.validation.constraints.NotBlank;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {

	@NotBlank
	private String login;
	@NotBlank
	private String senha;

	public LoginForm(@NotBlank String login, @NotBlank String senha) {
		this.login = login;
		this.senha = senha;
	}
	
	public UsernamePasswordAuthenticationToken map() {
		return new UsernamePasswordAuthenticationToken(login,senha);
	}
}
