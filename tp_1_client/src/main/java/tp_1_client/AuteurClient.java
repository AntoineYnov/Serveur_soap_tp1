package tp_1_client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import dao.IAuteurDAO;
import entity.Auteur;
import entity.Livre;

public class AuteurClient {

	private static final String URL_WSDL = "http://localhost:9998/Auteur?wsdl";

	private IAuteurDAO auteurDAO;
	
	public AuteurClient() throws MalformedURLException, JAXBException {
		URL url = new URL(URL_WSDL);
		QName qname = new QName("http://service/", "AuteurServiceService");
		Service service = Service.create(url, qname);

		auteurDAO = service.getPort(IAuteurDAO.class);
	}

	public IAuteurDAO getAuteurDAO() {
		return auteurDAO;
	}

	public void setAuteurDAO(IAuteurDAO auteurDAO) {
		this.auteurDAO = auteurDAO;
	}	
}
