package tr.gov.sg;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Calistir {
	// Base URI the Grizzly HTTP server will listen on
	public static final String BASE_URI = "http://localhost:8080/api/";

	/**
	 * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
	 * application.
	 * 
	 * @return Grizzly HTTP server.
	 */
	public static HttpServer startServer() {
		// Create a resource config that scans for JAX-RS resources and providers in
		// the package
		final ResourceConfig rc = new ResourceConfig().packages(true, "tr.gov.sg");

		// Create and start a new instance of the Grizzly HTTP server
		// Exposing the Jersey application at BASE_URI
		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
	}

	public static void main(String[] args) throws IOException {
		HttpServer server = startServer();
		System.out
				.println(String.format("Uygulama su url'de calisti: %s", BASE_URI));
		System.out.println("Durdurmak icin ENTER'a basın...");
		System.in.read();
		server.shutdownNow();
	}
}
