package com.example.demo.aspect;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//政治表达式 セキュリティ
@Aspect
@Component
public class MyAspect {
	private static Logger logger = Logger.getLogger(MyAspect.class); 
	@Autowired
	HttpSession session;
	@Around("execution(* com.example.demo.controller.*.*(..))")
    public Object sessionTimeOut(ProceedingJoinPoint pjp) throws IOException {
        Object result = null;
        String targetName = pjp.getTarget().getClass().getSimpleName();
        String methodName = pjp.getSignature().getName();
        logger.info("----------------実行方法-----------------");
        logger.info("Class名："+targetName+" メソッド名："+methodName);

        if(session.getAttribute("accountId")!=null){
            try {
                result = pjp.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return result;
        } else{
            logger.debug("セッションがタイムアウトし、ログインページに戻っています");
            return "redirect:/login";
        }
    } 
}
