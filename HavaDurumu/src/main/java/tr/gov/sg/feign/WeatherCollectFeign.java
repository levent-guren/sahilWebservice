package tr.gov.sg.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import feign.Headers;
import tr.gov.sg.model.Root;

@FeignClient(name = "collectApi", url = "https://api.collectapi.com/weather/getWeather")
public interface WeatherCollectFeign {
	@GetMapping
	@Headers({ "Content-Type: application/json" })
	Root havaDurumunuGetir(@RequestParam("data.lang") String dil,
			@RequestParam("data.city") String sehir,
			@RequestHeader("authorization") String token);
}
