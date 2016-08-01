package com.hyh.zkb.aop.log;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface OperationLogger {
	public String id() default "-1";
	public enum OperationType{ADD,UPDATE,DEL,SEARCH};
	OperationType type() default OperationType.SEARCH;
}
