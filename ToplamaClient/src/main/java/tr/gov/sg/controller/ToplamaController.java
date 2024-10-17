package tr.gov.sg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.sg.feign.ToplamaFeign;

@RestController
public class ToplamaController {
	@Autowired
	private ToplamaFeign toplamaFeign;

	@GetMapping
	public String toplama(int sayi1, int sayi2) {
		String sonuc = toplamaFeign.topla(sayi1, sayi2);
		return sonuc;
	}
}
