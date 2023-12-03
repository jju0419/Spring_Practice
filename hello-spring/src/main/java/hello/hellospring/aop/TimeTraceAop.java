package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;



//AOP : 핵심 관심사항과 공통 관심사항을 분리할 수 있으며 원하는 적용대상들만 공통 관심사항을 알아볼수 있다

@Aspect
@Component //스프링에서 알아서 빈에 등록해줌
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))")
    //이 메서드를 어디에다 사용할지 서술 excution( )안에 알맞은 형식으로 서술방식은 문서 참조
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{// 규격화된 형식으로 문서 참조하면 알수있음

        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : " + joinPoint.toString() + " " + timeMs + "ms");

        }

    }
}
