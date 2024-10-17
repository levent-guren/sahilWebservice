package tr.gov.sg;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tr.gov.sg.model.Gemi;

public class Calistir {
	public static void main(String[] args) {
		String url = "http://localhost:8080/api/gemiler";

		// Call JSON API
		HttpRequest jsonRequest = HttpRequest.newBuilder().uri(URI.create(url))
				.header("Accept", "application/json")
				// .POST(HttpRequest.BodyPublishers.ofString(""))
				.build();

		HttpClient client = HttpClient.newHttpClient();
		client.sendAsync(jsonRequest, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body).thenAccept(response -> {
					System.out.println("JSON Response:");
					// System.out.println(response);
					ObjectMapper mapper = new ObjectMapper();
					try {
						List<Gemi> gemiler = mapper.readValue(response,
								new TypeReference<List<Gemi>>() {
								});
						gemiler.forEach(System.out::println);
					} catch (JsonMappingException e) {
						e.printStackTrace();
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}

				}).join();
	}
}
