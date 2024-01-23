package hello.aop.order.aop.order;

import org.aspectj.lang.annotation.Pointcut;

// 외부에서 포이트컷 참조시 접근 제어자 public으로 해야함
public class Pointcuts {

    //hello.aop.order 패키지와 하위 패키지
    @Pointcut("execution(* hello.aop.order..*(..))")
    public void allOrder() {
    } // pointcut signature

    //class name pattern *Service
    @Pointcut("execution(* *..*Service.*(..))")
    public void allService() {

    }

    @Pointcut("allOrder() && allService()")
    public void orderAndService() {

    }
}
