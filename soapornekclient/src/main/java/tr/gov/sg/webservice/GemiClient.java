package tr.gov.sg.webservice;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import tr.gov.sg.webservice.wsdl.Gemi;
import tr.gov.sg.webservice.wsdl.GetGemiRequest;
import tr.gov.sg.webservice.wsdl.GetGemiResponse;

public class GemiClient extends WebServiceGatewaySupport {
	public Gemi getGemi(long id) {
		GetGemiRequest request = new GetGemiRequest();
		request.setId(id);
		GetGemiResponse response = (GetGemiResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8080/ws", request, new SoapActionCallback("http://tr.gov.sg/ws/gemi/GetGemiRequest"));
		return response.getGemi();
	}

}
