package br.com.zupacademy.mercado_livre.generic;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {ExistByIdValidator.class})
@Retention(RUNTIME)
@Target(FIELD)
public @interface ExistById {
	
	String message() default "Não existe esse id";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	Class<?> domainClass();
	String primaryKey() default "id";
}
