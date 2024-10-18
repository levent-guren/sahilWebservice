package tr.gov.sg.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "tr.gov.sg.feign")
public class FeignConfig {

}
