package br.com.zupacademy.mercado_livre.generic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object>{

	private String domainAttribute;
	private Class<?> clazz;
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void initialize(UniqueValue uniqueValue) {
		domainAttribute = uniqueValue.fieldName();
		clazz = uniqueValue.domainClass();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		String query = "select o."+ domainAttribute +" from "+ clazz.getName() +" o where o."+ domainAttribute +" = :pValue";
		Query createQuery = entityManager.createQuery(query);	
		createQuery.setParameter("pValue", value);
		List<?> list = createQuery.getResultList();
		Assert.state(list.size() <=1,"Foi encontrdo mais de um "+ clazz.getName() +" com o atributo "+domainAttribute);
		return list.isEmpty();
	}

}
