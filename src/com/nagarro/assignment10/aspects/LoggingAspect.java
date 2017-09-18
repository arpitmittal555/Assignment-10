package com.nagarro.assignment10.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.nagarro.assignment10.resourceconstants.ResLogger;

/**
 * The Class LoggingAspect implements the concept of AOP in spring and will log
 * the data before every service method whenever is called.
 */
@Aspect
public class LoggingAspect {

	/**
	 * All service methods advice will give the output whenever point cut method
	 * is called and will run before every service method implementation.
	 */
	@After("pointcut()")
	public void beforeServicedvice() {
		ResLogger.log.debug("Before executing service method");
	}

	/**
	 * All methods pointcut.Pointcut to execute on all the methods of classes in
	 * a package.
	 */
	@Pointcut("within(com.nagarro.assignment10.service.*)")
	public void pointcut() {
	}

}
