package tr.gov.sg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import tr.gov.sg.entity.Personel;
import tr.gov.sg.service.PersonelService;

@Component
@Path("/personeller")
public class PersonelController {
	@Autowired
	private PersonelService personelService;
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Personel> getTumPersoneller() {
		return personelService.getTumPersoneller();
	}
}
