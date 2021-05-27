package br.com.zupacademy.mercado_livre.usuario;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Email
	@Column(unique = true)
	private String login;
	@NotBlank
	@Size(min = 6)
	private String senha;
	@NotNull
	@PastOrPresent
	private LocalDateTime instanteCadastro;
	
	@SuppressWarnings("unused")
	@Deprecated
	private Usuario() {
	}
	
	public Usuario(@NotBlank @Email String login, @NotBlank @Size(min = 6) String senha,
			@NotNull @PastOrPresent LocalDateTime instanteCadastro) {
		super();
		this.login = login;
		this.senha = senha;
		this.instanteCadastro = instanteCadastro;
	}

	public String getLogin() {
		return this.login;
	}

	public String getSenha() {
		return this.senha;
	}

}
