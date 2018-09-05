package com.igeek;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//advice通知类增强类
@Component("myAspect")//相当于<bean id="myAspect" class="com.igeek.MyAspect"/>

@Aspect  // 
public class MyAspect {
	//前置通知
	//相当于：<aop:before method="before" pointcut="bean(*Service)"/>
    //@Before("bean(*Service)")：参数值：自动支持切入点表达式或切入点名字
//	@Before("bean(*Service)")
//	public void before(JoinPoint joinPoint){
//		System.out.println("=======前置通知。。。。。");
//	}
	
	
		//自定义切入点
		//方法名就是切入点的名字
		//相当于<aop:pointcut expression="bean(customerService)" id="myPointcut"/>
//		@Pointcut(value="bean(customerService)")
//		private void myPointcut(){}
//		//自定义切入点
//		//方法名就是切入点的名字
//		//相当于<aop:pointcut expression="bean(productService)" id="myPointcut2"/>
//		@Pointcut(value="bean(productService)")
//		private void myPointcut2(){}
//		
//		
//		//前置通知
//		//相当于：<aop:before method="before" pointcut-ref="myPointcut"/>
//		//相当于：<aop:before method="before" pointcut-ref="myPointcut2"/>
//		@Before("myPointcut()||myPointcut2()")//等同于@Before("bean(*Service)")
//		public void before(JoinPoint joinPoint){
//			System.out.println("=======前置通知。。。。。");
//		}
		
		//后置通知
//		//target：拦截某一个类型的bean（唯一），表示只对CustomerServiceImpl类中的方法做后置通知的查找
//		@AfterReturning(value="target(com.igeek.CustomerServiceImpl)",returning="returnVal")
//		public void afterReturning(JoinPoint joinPoint,Object returnVal){
//			System.out.println("=======后置通知。。。。。");
//		}
	
	//环绕通知：
//	@Around("execution(* com.igeek*.*(..))")//要增强返回类型任意，所有的com.igeek包中的类，类中所有的方法，参数任意
//	@Around("execution(* com.igeek..*.*(..))")//要增强返回类型任意，com.igeek包，及其子包中所有类，类中所有的方法，参数任意
//	@Around("execution(* com.igeek..*.save(..))")//要增强com.igeek包及其子包中所有的类，类中以save结尾的方法，参数任意
	//要增强com.igeek包中的ICustomerService类的子类型的所有方法，参数任意
//	@Around("execution(* com.igeek.ICustomerService+.*(..))")
//	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//		System.out.println("---环绕通知-----前");
//		Object object = proceedingJoinPoint.proceed();
//		System.out.println("---环绕通知-----后");
//		return object;
//	}
	//抛出通知
	//切入点表达式：增强所有com包以及子包下面的所有类型的bean的所有方法
//	@AfterThrowing(value="within(com..*)",throwing="ex")
//	public void afterThrowing(JoinPoint joinPoint ,Throwable ex){
//		System.out.println("---抛出通知。。。。。。"+"抛出的异常信息："+ex.getMessage());
//	}


	@After("bean(*ice)")
	public void after(JoinPoint joinPoint){
		System.out.println("+++++++++最终通知。。。。。。。");
	}



}
