package com.hyh.zkb.aop.log;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.hyh.zkb.aop.log.OperationLogger.OperationType;

@Aspect
@Component
public class SysLogAspect {
	private static final Logger logger = LoggerFactory.getLogger(SysLogAspect.class);

	@Pointcut("@annotation(com.hyh.zkb.aop.log.OperationLogger)")
	public void controllerAspect() {

	}

	@Before("controllerAspect()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("=====SysLogAspectǰ��֪ͨ��ʼ=====");
		handleLog(joinPoint, null);
	}

	@AfterReturning(pointcut = "controllerAspect()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("=====SysLogAspect����֪ͨ��ʼ=====");
		handleLog(joinPoint, null);
	}

	@AfterThrowing(value = "controllerAspect()", throwing = "e")
	public void doAfter(JoinPoint joinPoint, Exception e) {
		System.out.println("=====SysLogAspect�쳣֪ͨ��ʼ=====");
		handleLog(joinPoint, e);
	}

	private void handleLog(JoinPoint joinPoint, Exception e) {
		try {
			//���ע��
			OperationLogger logger = giveController(joinPoint);
			if (logger == null) {
				return;
			}
			// ��ȡĿ�귽��ǩ��  "����ֵ ȫ����.������(��������)"
			String signature = joinPoint.getSignature().toString();
//			System.out.println("==signature:"+signature);
//			System.out.println("==joinpoint:" + joinPoint.toString());
			String methodName = signature.substring(signature.lastIndexOf(".")+1, signature.indexOf("("));
//			String longTemp = joinPoint.getStaticPart().toLongString();
//			System.out.println(joinPoint.getStaticPart());
//			System.out.println("==longtemp:"+longTemp);
			String classType = joinPoint.getTarget().getClass().getName();
//			System.out.println("==classType:"+classType);
			Class<?> clazz = Class.forName(classType);
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				if (method.isAnnotationPresent(OperationLogger.class) && method.getName().equals(methodName)) {
					String annId = logger.id();
					OperationType type = logger.type();
					String clazzName = clazz.getName();
					System.out.println("clazzName: " + clazzName + ", methodName: " + methodName + ", annId: " + annId
							+ ", type: " + type.toString());
				}
			}
		} catch (Exception exp) {
			logger.error("�쳣��Ϣ:{}", exp.getMessage());
			exp.printStackTrace();
		}

	}
	private static OperationLogger giveController(JoinPoint joinPoint) throws Exception {
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();

		if (method != null) {
			return method.getAnnotation(OperationLogger.class);
		}

		return null;
	}

	public void insertLogSuccess(JoinPoint jp, OperationLogger logger) {
	}
	public void writeLogInfo(JoinPoint joinPoint, OperationLogger opLogger) throws Exception, IllegalAccessException {
	}
}
