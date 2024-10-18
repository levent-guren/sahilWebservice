package tr.gov.sg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.gov.sg.dto.GemiResponseDTO;
import tr.gov.sg.model.Gemi;
import tr.gov.sg.service.GemiService;

@RestController
public class GemiController {
	@Autowired
	private GemiService gemiService;

	@GetMapping
	public List<GemiResponseDTO> getGemiler(String ilAdi) {
		List<Gemi> gemiler = gemiService.getGemiler(ilAdi);
		return GemiResponseDTO.fromGemiList(gemiler);
	}

}
