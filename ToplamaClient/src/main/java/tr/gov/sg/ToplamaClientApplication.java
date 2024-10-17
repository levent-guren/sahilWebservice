package tr.gov.sg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ToplamaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToplamaClientApplication.class, args);
	}

}
