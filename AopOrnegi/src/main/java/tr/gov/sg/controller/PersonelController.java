package tr.gov.sg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.sg.model.Personel;
import tr.gov.sg.service.PersonelService;

@RestController
public class PersonelController {
	@Autowired
	private PersonelService personelService;

	@GetMapping("/personeller")
	public List<Personel> getPersoneller() {
		return personelService.getPersoneller();
	}
}
