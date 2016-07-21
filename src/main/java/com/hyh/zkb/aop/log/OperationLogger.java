package com.hyh.zkb.aop.log;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)//ע�����class�д��ڣ�����ʱ��ͨ�������ȡ
@Target(ElementType.METHOD)//ע��Ŀ���Ƿ���
@Documented//�����ĵ�ʱ����ע�⽫��������javadoc�У���ȥ��
public @interface OperationLogger {
	public String id() default "-1";
	public enum OperationType{ADD,UPDATE,DEL,SEARCH};
	OperationType type() default OperationType.SEARCH;
}
