package tr.gov.sg.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class SureHesaplaAspect {
	@Around("execution(* tr.gov.sg.service..*(..))")
	public Object sureHesapla(ProceedingJoinPoint joinPoint) throws Throwable {
		final StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object result = joinPoint.proceed();
		stopWatch.stop();
		System.out.println("-----------");
		System.out.println("Class: " + joinPoint.getTarget().getClass().getName());
		System.out.println("Metod: " + joinPoint.getSignature().getName());
		System.out.println("Sure (ns): " + stopWatch.getTotalTimeNanos());
		System.out.println("Donen cevap: " + result);
		return result;
	}
}
