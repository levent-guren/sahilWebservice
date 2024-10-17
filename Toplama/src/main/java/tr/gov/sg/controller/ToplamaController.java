package tr.gov.sg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToplamaController {
	@GetMapping
	public int toplama(int sayi1, int sayi2) {
		return sayi1 + sayi2;
	}
}
