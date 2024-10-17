package tr.gov.sg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopOrnegiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopOrnegiApplication.class, args);
	}

}
