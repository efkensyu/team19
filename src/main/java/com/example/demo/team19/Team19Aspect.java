package com.example.demo.team19;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class Team19Aspect {
	@Around("execution(* com.example.demo.team19.Team19Controller.*(..))")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable{	
		try {
			log.info("メソッド開始:" + jp.getSignature());
			Object result = jp.proceed();
			return result;
			}catch(Exception e) {
				return "team19/error";
			}
		}
}
