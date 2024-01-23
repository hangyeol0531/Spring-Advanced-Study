package hello.aop.order.aop.order;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Slf4j
@Aspect
public class AspectV6Advice {

    // hello.aop.order 패키지와 하위 패키지이면서 클래스 이름 패턴이 *Service
//    @Around("hello.aop.order.aop.order.Pointcuts.orderAndService()")
//    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
//        try {
//            // @Before
//            log.info("[Transaction Start] {}", joinPoint.getSignature());
//            Object result = joinPoint.proceed();
//            // @AfterReturning
//            log.info("[Transaction Commit] {}", joinPoint.getSignature());
//            return result;
//        } catch (Exception e) {
//            // @AfterThrowing
//            log.info("[Transaction Rollback] {}", joinPoint.getSignature());
//            throw e;
//        } finally {
//            // @After
//            log.info("[Resource release] {}", joinPoint.getSignature());
//        }
//    }

    @Before("hello.aop.order.aop.order.Pointcuts.orderAndService()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("[before] {}", joinPoint.getSignature());
    }

    // returning - return 인자 값
    @AfterReturning(value = "hello.aop.order.aop.order.Pointcuts.orderAndService()", returning = "result")
    public void doReturn1(JoinPoint joinPoint, Object result) {
        log.info("[return1] {} return={}", joinPoint.getSignature(), result);
    }

    // aop걸려있는 메서드 return값을 맞춰줘야 실행됨
    @AfterReturning(value = "hello.aop.order.aop.order.Pointcuts.allOrder()", returning = "result")
    public void doReturn2(JoinPoint joinPoint, String result) {
        log.info("[return2] {} return={}", joinPoint.getSignature(), result);
    }

    @AfterThrowing(value = "hello.aop.order.aop.order.Pointcuts.orderAndService()", throwing = "ex")
    public void doThrowing(JoinPoint joinPoint, Exception ex) {
        log.info("[ex] {} message={}", joinPoint.getSignature(), ex);
    }

    @After("hello.aop.order.aop.order.Pointcuts.orderAndService()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("[after] {}", joinPoint.getSignature());
    }
}
