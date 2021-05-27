package br.com.zupacademy.mercado_livre.confg.security;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.zupacademy.mercado_livre.usuario.Usuario;

@Service
public class BuscaUserDetails implements UserDetailsService{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		TypedQuery<Usuario> query = entityManager.createQuery("select u from Usuario u where u.login = :login",Usuario.class);
		query.setParameter("login", login);
		Usuario usuario = query.getSingleResult();
		return new UsuarioLogado(usuario);
	}

}
