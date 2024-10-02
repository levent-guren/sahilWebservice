package tr.gov.sg.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.sg.dto.GlobalResponseDTO;
import tr.gov.sg.dto.birlik.BirlikEkleGuncelleRequestDTO;
import tr.gov.sg.dto.birlik.BirlikEkleGuncelleResponseDTO;
import tr.gov.sg.dto.birlik.TumBirliklerResponseDTO;
import tr.gov.sg.entity.Birlik;
import tr.gov.sg.service.BirlikService;

@RestController
@RequestMapping("/api/v1/birlik")
public class BirlikController {
	@Autowired
	private BirlikService birlikService;
	@Autowired
	private ModelMapper mapper;

	@PostMapping("/hepsi")
	public ResponseEntity<List<TumBirliklerResponseDTO>> getTumBirlikler() {
		List<Birlik> tumBirlikler = birlikService.getTumBirlikler();
//		List<TumBirliklerResponseDTO> result = tumBirlikler.stream().map(b -> {
//			TumBirliklerResponseDTO dto = mapper.map(b, TumBirliklerResponseDTO.class);
//			dto.setToplamGemiSayisi(b.getGemiler().size());
//			return dto;
//		}).toList();
//
		List<TumBirliklerResponseDTO> result = new ArrayList<>();
		for (int i = 0; i < tumBirlikler.size(); i++) {
			Birlik b = tumBirlikler.get(i);

			TumBirliklerResponseDTO dto = mapper.map(b, TumBirliklerResponseDTO.class);
			dto.setToplamGemiSayisi(b.getGemiler().size());

			result.add(dto);
		}
		return ResponseEntity.ok(result);
	}

	@PostMapping("/ekleguncelle")
	public ResponseEntity<BirlikEkleGuncelleResponseDTO> ekleGuncelle(@RequestBody BirlikEkleGuncelleRequestDTO dto) {
		Birlik birlik = mapper.map(dto, Birlik.class);
		Birlik birlikDb = birlikService.birlikEkleGuncelle(birlik);
		BirlikEkleGuncelleResponseDTO result = mapper.map(birlikDb, BirlikEkleGuncelleResponseDTO.class);
		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/sil")
	public ResponseEntity<GlobalResponseDTO> birlikSil(long id) {
		birlikService.birlikSil(id);
		return ResponseEntity.ok(new GlobalResponseDTO());
	}

	@PostMapping("/")
	public ResponseEntity<Object> birlikGetir(long id) {
		Optional<Birlik> oBirlik = birlikService.getBirlikById(id);
		if (oBirlik.isPresent()) {
			Birlik birlik = oBirlik.get();
			TumBirliklerResponseDTO result = mapper.map(birlik, TumBirliklerResponseDTO.class);
			result.setToplamGemiSayisi(birlik.getGemiler().size());
			return ResponseEntity.ok(result);
		}
		// kayıt bulunamadı
		return ResponseEntity.ok(new GlobalResponseDTO("error", "Bulunamadı", 405));
	}

}
