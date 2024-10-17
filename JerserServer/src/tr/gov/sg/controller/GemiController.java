package tr.gov.sg.controller;

import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import tr.gov.sg.model.Gemi;

@Path("/gemiler")
public class GemiController {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Gemi> getTumGemiler() {
		return Arrays.asList(new Gemi("Hızır", "Buzkıran", 13),
				new Gemi("Rüzgar", "Feribot", 83), new Gemi("Fırtına", "Vapur", 45));
	}
}
