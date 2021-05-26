package br.com.zupacademy.mercado_livre.generic;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
/**
 * Caso o campo seja nulo a validação ira passar
 * 
 * @author gabriel.barbosa
 *
 */

public class ExistByIdValidator implements ConstraintValidator<ExistById, Object>{

	private Class<?> clazz;
	private String namePrimaryKey;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void initialize(ExistById annotation) {
		clazz = annotation.domainClass();
		namePrimaryKey = "id";
	}
	
	@Override
	public boolean isValid(Object primaryKey, ConstraintValidatorContext context) {
		if(primaryKey == null) return true;
		Query query = entityManager.createQuery("select c."+namePrimaryKey+" from "+clazz.getName()+" c where c."+namePrimaryKey+" = :primaryKey");
		query.setParameter("primaryKey", primaryKey);
		return !query.getResultList().isEmpty();
	}

}
