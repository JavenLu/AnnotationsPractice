package javen.example.com.annotationspractice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Javen on 01/03/2018.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RuntimeAnnotation  {
    String value();
    String[] value2() default "value2";
}
