package edu.hm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Softwarearchitektur Praktikumsaufgabe 1.
 * @author Aykut Yilmaz, Julian Keppeler
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface RenderMe {

    String with() default "";

}
