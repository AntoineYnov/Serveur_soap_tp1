package endpoint;

import javax.xml.ws.Endpoint;

import service.LivreService;


public class LivreEndpoint {

	public LivreEndpoint() {
        Endpoint.publish(
                "http://localhost:9998/Livre",
                new LivreService());
	}
}
