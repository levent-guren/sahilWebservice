package tr.gov.sg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import tr.gov.sg.feign.WeatherCollectFeign;
import tr.gov.sg.model.Root;

@Service
public class HavaDurumuService {
	@Autowired
	private WeatherCollectFeign collectFeign;
	@Value("${collectApiToken}")
	private String apiKey;

	public Root getHavaDurumu(String il) {
		Root root = collectFeign.havaDurumunuGetir("tr", il, apiKey);
		return root;
	}
}
