package com.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

//	setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

//	point-cut
	@Pointcut("execution(* com.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.springdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("execution(* com.springdemo.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
	private void AppFlow() {
	}

//	add @Before
	@Before("AppFlow()")
	public void before(JoinPoint JP) {
//		find methodName
		String methodName = JP.getSignature().toShortString();

		myLogger.info("In @Before for : " + methodName);

		for (var arg : JP.getArgs()) {
			myLogger.info("@Before : " + methodName + " arg : " + arg);
		}
	}

	@AfterReturning(pointcut = "AppFlow()", returning = "data")
	public void afterReturning(JoinPoint JP, Object data) {

		String methodName = JP.getSignature().toShortString();

		myLogger.info("In @AfterReturning for : " + methodName);

		myLogger.info("Returned Value : " + data);

	}

}
