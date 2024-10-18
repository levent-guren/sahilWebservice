package tr.gov.sg.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.sg.dto.gemi.GemiRequestDTO;
import tr.gov.sg.dto.gemi.GemiResponseDTO;
import tr.gov.sg.entity.Gemi;
import tr.gov.sg.service.GemiService;

@RestController
@RequestMapping("/gemi")
public class GemiController {
	@Autowired
	private GemiService gemiService;
	@Autowired
	private ModelMapper mapper;

	@PostMapping("/il")
	public List<GemiResponseDTO> getGemiler(@RequestBody GemiRequestDTO req) {
		List<Gemi> sonuclar = gemiService.getGemilerByIlAdi(req.getIlAdi());
		return sonuclar.stream().map(gemi -> mapper.map(gemi, GemiResponseDTO.class))
				.toList();
	}

	// ModelMapper sınıfının map fonsiyonu (yukarıda kullandık)
	// altta yazdığımız fonsiyonun içindeki gibi bir işlem yapıyor.
	// Ama bunu dinamik olarak her iki sınıfın da değişken isimlerine bakarak
	// yapıyor. Bu yüzden GemiResponseDTO sınıfındaki değişken isimlerini
	// Gemi sınıfındakiler ile aynı verdik.
	public GemiResponseDTO cevir(Gemi gemi) {
		GemiResponseDTO sonuc = new GemiResponseDTO();
		sonuc.setAdi(gemi.getAdi());
		sonuc.setTipi(gemi.getTipi());
		// ....
		return sonuc;
	}
}
