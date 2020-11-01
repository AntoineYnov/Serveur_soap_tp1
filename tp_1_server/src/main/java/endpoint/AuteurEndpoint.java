package endpoint;

import javax.xml.ws.Endpoint;

import service.AuteurService;


public class AuteurEndpoint {
	
	public AuteurEndpoint() {
        Endpoint.publish(
                "http://localhost:9998/Auteur",
                new AuteurService());
	}

}
