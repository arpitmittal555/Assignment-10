package com.nagarro.assignment10.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.nagarro.assignment10.resourceconstants.ResLogger;

/**
 * The Class LoggingAspectService implements the concept of AOP in spring and
 * will log the data before every service method whenever is called.
 */
@Aspect
public class LoggingAspectDao {

	/**
	 * All service methods advice will give the output whenever pointcut method
	 * is called and will run before every service method implementation.
	 */
	@Before("pointcut()")
	public void beforeServiceAdvice() {
		ResLogger.log.error("After executing Dao method");
	}

	/**
	 * All methods pointcut.Pointcut to execute on all the methods of classes in
	 * a package.
	 */
	@Pointcut("within(com.nagarro.assignment10.dao.*)")
	public void pointcut() {
	}

}
