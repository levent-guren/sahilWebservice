package tr.gov.sg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import tr.gov.sg.webservice.GemiClient;
import tr.gov.sg.webservice.wsdl.Gemi;

@Component
public class GemiWebServiceTest implements CommandLineRunner {
	@Autowired
	private GemiClient gemiClient;

	@Override
	public void run(String... args) throws Exception {
		Gemi gemi = gemiClient.getGemi(2);
		System.out.println(gemi.getAdi());
	}

}
