package tr.gov.sg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import tr.gov.sg.dto.GemiDTO;
import tr.gov.sg.feign.GemiFeign;
import tr.gov.sg.model.Gemi;

@Service
public class GemiService {
	@Autowired
	private GemiFeign gemiFeign;
	@Value("${feignusername}")
	private String username;
	@Value("${feignpassword}")
	private String password;

	public List<Gemi> getGemiler(String ilAdi) {
		return gemiFeign.getGemiler(new GemiDTO(ilAdi), username, password);
	}
}
