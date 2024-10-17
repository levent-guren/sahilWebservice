package tr.gov.sg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.gov.sg.db.PersonelDB;
import tr.gov.sg.model.Personel;

@Service
public class PersonelService {
	@Autowired
	private PersonelDB personelDB;

	public List<Personel> getPersoneller() {
		return personelDB.getPersoneller();
	}
}
