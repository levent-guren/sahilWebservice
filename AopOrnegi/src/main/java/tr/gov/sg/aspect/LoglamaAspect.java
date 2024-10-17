package tr.gov.sg.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoglamaAspect {
	@After("execution(* tr.gov.sg.db..*(..)) && target(bean)")
	public void log(JoinPoint jp, Object bean) {
		System.out.println("Loglama çağırıldı");
		System.out.println("Target: " + bean.getClass().getName());
		System.out.println("Method: " + jp.getSignature().getName());
	}
}
