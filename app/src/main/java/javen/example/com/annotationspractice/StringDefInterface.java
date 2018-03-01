package javen.example.com.annotationspractice;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static javen.example.com.annotationspractice.StringDefInterface.STATUS_INVALID;
import static javen.example.com.annotationspractice.StringDefInterface.STATUS_VALID;

/**
 * Created by Javen on 01/03/2018.
 */


/**
 * 自定义枚举类型
 */
//声明一个可取值为STATUS_VALID和STATUS_INVALID的枚举类型。
//RetentionPolicy.SOURCE标记新的注解只在源码生效

@Retention(RetentionPolicy.SOURCE)
@StringDef({STATUS_VALID, STATUS_INVALID})
public @interface StringDefInterface {
    public static final String STATUS_VALID = "VALID";
    public static final String STATUS_INVALID = "INVALID";

}

