package tr.gov.sg.db;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import tr.gov.sg.model.Personel;

@Component
public class PersonelDB {
	public List<Personel> getPersoneller() {
		// @formatter:off
		return Arrays.asList(
				new Personel("Kamuran", 38),
				new Personel("Şazument", 23), 
				new Personel("Lalezar", 41),
				new Personel("Mahmure", 34), 
				new Personel("Kezban", 21)
			);
		// @formatter:on
	}
}
