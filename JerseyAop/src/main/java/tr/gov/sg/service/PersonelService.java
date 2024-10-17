package tr.gov.sg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tr.gov.sg.entity.Personel;

@Service
public class PersonelService {
	public List<Personel> getTumPersoneller() {
		// TODO: Database call to fetch all personnel data
        return List.of(new Personel(101, "John", "Doe"), new Personel(102, "Jane", "Smith"));
	}
}
