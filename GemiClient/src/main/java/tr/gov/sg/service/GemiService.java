package tr.gov.sg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.gov.sg.dto.GemiDTO;
import tr.gov.sg.feign.GemiFeign;
import tr.gov.sg.model.Gemi;

@Service
public class GemiService {
	@Autowired
	private GemiFeign gemiFeign;

	public List<Gemi> getGemiler(String ilAdi) {
		return gemiFeign.getGemiler(new GemiDTO(ilAdi));
	}
}
