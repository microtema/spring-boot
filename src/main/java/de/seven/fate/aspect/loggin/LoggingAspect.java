package de.seven.fate.aspect.loggin;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* publishEvent(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable{

        System.out.println("logAround() is running!");
        System.out.println("hijacked method : " + joinPoint.getSignature().getName());
        System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));

        System.out.println("Around before is running!");
        joinPoint.proceed(); //continue on the intercepted method
        System.out.println("Around after is running!");

        System.out.println("******");
    }

    @Before("execution(* publishEvent(..))")
    public void logBefore(JoinPoint joinPoint){

        System.out.println("logBefore() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }

    @After("execution(* publishEvent(..))")
    public void logAfter(JoinPoint joinPoint){

        System.out.println("logAfter() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }

    @AfterReturning(pointcut = "execution(* publishEvent(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){

        System.out.println("logAfterReturning() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is : " + result);
        System.out.println("******");
    }

    @PostConstruct
    private void init(){
        System.out.println(this);
    }
}
