package de.seven.fate.aspect;

import de.seven.fate.enums.UserName;
import de.seven.fate.util.ClassUtil;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserNameAspect {

    private static final Logger LOGGER = Logger.getLogger(UserNameAspect.class);


    @Around("execution(* de.seven.fate..rest.*.*(..))")
    public Object applyUserName(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        Object[] arguments = joinPoint.getArgs();

        int indexOfParameter = ClassUtil.getIndexOfParameter(signature.getMethod().getParameterAnnotations(), UserName.class);

        if (indexOfParameter != -1) {

            arguments[indexOfParameter] = getUserName();
        }

        return joinPoint.proceed(arguments);
    }

    private String getUserName() {

        return "mtema"; // return getSessionContext().getCallerPrincipal().getName();
    }
}
