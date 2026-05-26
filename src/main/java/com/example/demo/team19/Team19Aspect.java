package com.example.demo.team19;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class Team19Aspect {
	
	@Around("execution(* com.example.demo.team19.*.*(..))")
	public Object errorLog(ProceedingJoinPoint jp) throws Throwable{	
		try {
			Object result = jp.proceed();
			return result;
			}catch(Exception e) {
				return "team19/Team19Error";
			}
		}
	@Around("execution(* com.example.demo.team19.Team19Controller.*(..))")
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable{	
		
			log.info("メソッド開始:" + jp.getSignature());
			log.info("引数=[{}]", Arrays.toString(jp.getArgs()));
			Object result = jp.proceed();
			log.info("メソッド終了:" + jp.getSignature());
			return result;
		}
		
	
	@AfterReturning("execution(* com.example.demo.*.*.*(..))")
	public void afterReturningLog(JoinPoint jp){	
		log.info("メソッド正常終了:" + jp.getSignature());
		}
	
	@AfterThrowing("execution(* com.example.demo.*.*.*(..))")
	public void throwingLog(JoinPoint jp){	
		log.error("メソッド異常:" + jp.getSignature());
		}
}
