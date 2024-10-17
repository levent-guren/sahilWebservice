package tr.gov.sg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.sg.model.HavaDurumuResponse;
import tr.gov.sg.model.Result;
import tr.gov.sg.model.Root;
import tr.gov.sg.service.HavaDurumuService;

@RestController
public class HavaDurumuController {
	@Autowired
	private HavaDurumuService havaDurumuService;

	@GetMapping("/havadurumu")
	public Root havaDurumu(String il) {
		return havaDurumuService.getHavaDurumu(il);
	}

	@GetMapping("/havadurumu2")
	public List<HavaDurumuResponse> havaDurumu2(String il) {
		Root root = havaDurumuService.getHavaDurumu(il);
		root.getResult().stream().forEach(r -> {
			// r'yi veritabanına kaydet
			System.out.println(r);
		});
		System.out.println("----------------------");
		List<HavaDurumuResponse> sonuc = root.getResult().stream().map(this::cevir)
				.toList();
		sonuc.forEach(r -> {
			// r'yi veritabanına kaydet
			System.out.println(r);
		});
		return sonuc;
	}

	/**
	 * Bu fonksiyon Result tipindeki objesi HavaDurumuResponse tipine çevirir.
	 * 
	 * @param result
	 * @return
	 */
	public HavaDurumuResponse cevir(Result result) {
		HavaDurumuResponse response = new HavaDurumuResponse();
		response.setDate(result.getDate());
		response.setDay(result.getDay());
		response.setDegree(Double.valueOf(result.getDegree()).intValue());
		response.setDescription(result.getDescription());
		response.setHumidity(result.getHumidity());
		return response;
	}

}
