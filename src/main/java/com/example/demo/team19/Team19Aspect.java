package com.example.demo.team19;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Team19Aspect {
	@Around("execution(* com.example.demo.team19.Team19Controller.*)")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable{	
		System.out.println("[Around]メソッド開始:" + jp.getSignature());
		Object result = jp.proceed();
		System.out.println("[Around]メソッド終了:" + jp.getSignature());
		return result;
		}
}
