package de.desertfox.random.annotation;

import de.desertfox.random.person.Gender;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Name {

	Gender gender() default Gender.NONE;

	boolean fullName() default true;


}
