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
		System.out.println("=====SysLogAspect前置通知开始=====");
		handleLog(joinPoint, null);
	}

	@AfterReturning(pointcut = "controllerAspect()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("=====SysLogAspect后置通知开始=====");
		handleLog(joinPoint, null);
	}

	@AfterThrowing(value = "controllerAspect()", throwing = "e")
	public void doAfter(JoinPoint joinPoint, Exception e) {
		System.out.println("=====SysLogAspect异常通知开始=====");
		handleLog(joinPoint, e);
	}

	private void handleLog(JoinPoint joinPoint, Exception e) {
		try {
			//获得注解
			OperationLogger logger = giveController(joinPoint);
			if (logger == null) {
				return;
			}
			// 获取目标方法签名  "返回值 全类名.方法名(参数类型)"
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
			logger.error("异常信息:{}", exp.getMessage());
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
