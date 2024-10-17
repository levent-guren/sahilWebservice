package tr.gov.sg.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.ApplicationPath;
import tr.gov.sg.controller.PersonelController;

@Configuration
@ApplicationPath("/jersey")
public class JerseyConfig extends ResourceConfig {
	
	@PostConstruct
	public void init() {
        register(PersonelController.class);
    }
}
