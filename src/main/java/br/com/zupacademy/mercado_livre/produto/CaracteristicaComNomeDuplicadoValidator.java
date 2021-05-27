package br.com.zupacademy.mercado_livre.produto;

import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CaracteristicaComNomeDuplicadoValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ProdutoForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		ProdutoForm form = (ProdutoForm) target;
		
		Set<String> nomes = form.buscaNomesCaracteristicaDuplicados();
		
		for(String nome : nomes) {
			String mensagem = String.format("á mais de um Caracteristica com o nome '%s', e so pode haver uma", nome);
			errors.rejectValue("caracteristicas", null, mensagem);
		}
	}

}
