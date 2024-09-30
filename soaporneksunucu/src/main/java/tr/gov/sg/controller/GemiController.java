package tr.gov.sg.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import sg.gov.tr.ws.gemi.GetGemiRequest;
import sg.gov.tr.ws.gemi.GetGemiResponse;
import tr.gov.sg.entity.Gemi;
import tr.gov.sg.service.GemiService;

@Endpoint
public class GemiController {
	private static final String NAMESPACE_URI = "http://tr.gov.sg/ws/gemi";

	@Autowired
	private GemiService gemiService;
	@Autowired
	private ModelMapper mapper;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getGemiRequest")
	@ResponsePayload
	public GetGemiResponse getGemi(@RequestPayload GetGemiRequest request) {
		Optional<Gemi> oGemi = gemiService.getGemi(request.getId());
		GetGemiResponse response = new GetGemiResponse();
		if (oGemi.isPresent()) {
			Gemi gemi = oGemi.get();
			sg.gov.tr.ws.gemi.Gemi respGemi = mapper.map(gemi, sg.gov.tr.ws.gemi.Gemi.class);
			response.setGemi(respGemi);
		}
		return response;
	}
}
