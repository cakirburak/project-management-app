package com.jrp.pma.logging;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
//@Component  // wihout this it wont load to Spring Context
public class ApplicationLoggerAspect {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("within(com.jrp.pma.controllers..*)")
	public void definePackagePointcutsControllers() {
		// empty method just to name the location specified in the pointcut
	}

	@Pointcut("within(com.jrp.pma.services..*)")
	public void definePackagePointcutsServices() {
		// empty method just to name the location specified in the pointcut
	}

	@Before("definePackagePointcutsControllers()")
	public void logBefore(JoinPoint jp) {
		log.debug("------Before Controller------");
		log.debug(jp.getSignature().getDeclaringTypeName());
		log.debug(jp.getSignature().getName());
		log.debug(Arrays.toString(jp.getArgs()));
		log.debug("-----------------------------");
	}

	@After("definePackagePointcutsControllers()")
	public void logAfter(JoinPoint jp) {
		log.debug("------After Controller------");
		log.debug(jp.getSignature().getDeclaringTypeName());
		log.debug(jp.getSignature().getName());
		log.debug(Arrays.toString(jp.getArgs()));
		log.debug("----------------------------");
	}

	@Around("definePackagePointcutsServices()")
	public Object logAround(ProceedingJoinPoint pjp) {
		log.debug("------Before Service------");
		log.debug(pjp.getSignature().getDeclaringTypeName());
		log.debug(pjp.getSignature().getName());
		log.debug(Arrays.toString(pjp.getArgs()));
		log.debug("-----------------------------");

		Object o = null;
		try {
			o = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		log.debug("------After Service------");
		log.debug(pjp.getSignature().getDeclaringTypeName());
		log.debug(pjp.getSignature().getName());
		log.debug(Arrays.toString(pjp.getArgs()));
		log.debug("----------------------------");

		return o;
	}
}
