package tr.gov.sg.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "toplama", url = "http://localhost:8080")
public interface ToplamaFeign {
	@GetMapping
	public String topla(@RequestParam int sayi1, @RequestParam int sayi2);
}
