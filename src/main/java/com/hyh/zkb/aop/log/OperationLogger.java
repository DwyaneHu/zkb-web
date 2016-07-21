package com.hyh.zkb.aop.log;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)//注解会在class中存在，运行时可通过反射获取
@Target(ElementType.METHOD)//注解目标是方法
@Documented//生成文档时，该注解将被包含在javadoc中，可去掉
public @interface OperationLogger {
	public String id() default "-1";
	public enum OperationType{ADD,UPDATE,DEL,SEARCH};
	OperationType type() default OperationType.SEARCH;
}
