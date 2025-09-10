package lx.edu.springmvc.aop;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.coyote.Request;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import lx.edu.springmvc.dao.RequestLogDAO;
import lx.edu.springmvc.vo.RequestLogVO;

@Aspect
@Component
@EnableAspectJAutoProxy
public class RequestLogAdvice {
	@Autowired
	RequestLogDAO dao;
   
	@Before("execution(* lx.edu.springmvc.controller.Addr*.*(..))")
	public void beforeLog(JoinPoint joinPoint) throws Exception {
		System.out.println("RequestLogAdvice.beforeLog()");
		Class targetClass = joinPoint.getTarget().getClass();
		String targetClassName = targetClass.getName();
		String methodName = joinPoint.getSignature().getName();
		System.out.printf("class=%s, method=%s/n", targetClassName,methodName);
		
		LocalDateTime now = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String formattedDateTime = now.format(formatter);
		
		RequestLogVO vo = new RequestLogVO();
		vo.setReqClass(targetClassName);
		vo.setReqMethod(methodName);
		vo.setReqTime(formattedDateTime);
		dao.insertDB(vo);
	}
}
