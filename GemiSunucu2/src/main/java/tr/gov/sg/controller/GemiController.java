package tr.gov.sg.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.sg.dto.gemi.GemiRequestDTO;
import tr.gov.sg.dto.gemi.GemiResponseDTO;
import tr.gov.sg.dto.gemi.Kaptan;
import tr.gov.sg.entity.Gemi;
import tr.gov.sg.service.GemiService;

@RestController
@RequestMapping("/gemi")
public class GemiController {
	@Autowired
	private GemiService gemiService;
	@Autowired
	private ModelMapper mapper;
	private static final String[] kaptanIsimleri = { "Açangül", "Afet", "Akpınar",
			"Cemre", "Dürdane", "Düş", "Füsun" };

	@PostMapping("/il")
	public List<GemiResponseDTO> getGemiler(@RequestBody GemiRequestDTO req) {
		List<Gemi> sonuclar = gemiService.getGemilerByIlAdi(req.getIlAdi());
		return sonuclar.stream().map(gemi -> mapper.map(gemi, GemiResponseDTO.class))
				.map(this::kaptanEkle).toList();
	}

	private GemiResponseDTO kaptanEkle(GemiResponseDTO dto) {
		dto.setKaptanlar(getKaptanListesi());
		return dto;
	}

	private List<Kaptan> getKaptanListesi() {
		List<Kaptan> kaptanlar = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < random.nextInt(2, 10); i++) {
			Kaptan kaptan = new Kaptan();
			kaptan.setAdi(
					kaptanIsimleri[new Random().nextInt(kaptanIsimleri.length)]);
			kaptan.setTcNo(random.nextLong(10000000000L, 99999999999L));
			kaptanlar.add(kaptan);
		}
		return kaptanlar;
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
