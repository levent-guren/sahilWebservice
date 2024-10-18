package tr.gov.sg.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tr.gov.sg.dto.GemiDTO;
import tr.gov.sg.model.Gemi;

@FeignClient(name = "gemi", url = "http://192.168.0.77:8080/gemi/il")
public interface GemiFeign {
	@PostMapping
	public List<Gemi> getGemiler(@RequestBody GemiDTO gemiDto);
}
