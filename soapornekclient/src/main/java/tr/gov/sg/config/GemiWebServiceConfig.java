package tr.gov.sg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import tr.gov.sg.webservice.GemiClient;

@Configuration
public class GemiWebServiceConfig {
	@Bean
	Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("tr.gov.sg.webservice.wsdl");
		return marshaller;
	}

	@Bean
	GemiClient gemiClient(Jaxb2Marshaller marshaller) {
		GemiClient client = new GemiClient();
		client.setDefaultUri("http://localhost:8080/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
