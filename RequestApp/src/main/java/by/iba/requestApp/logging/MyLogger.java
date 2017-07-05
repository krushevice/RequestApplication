package by.iba.requestApp.logging;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*@Aspect*/

public class MyLogger {

	/*@Pointcut("execution(* by.iba.requestApp.dao.UserDao.*(..))")*/
	/*private void allMethods() {
	};*/

	/*@Before("allMethods()")*/
	public void watchTime() {
		long start = System.currentTimeMillis();
		long time = System.currentTimeMillis() - start;
		//System.out.println("time=" + time);
	}	
	public void close(){
		//System.out.println("close");
	}
	public void around(){
		//System.out.println("around");
	}
}

