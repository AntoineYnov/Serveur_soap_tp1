package tp_1_client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import dao.ILivreDAO;
import entity.Auteur;
import entity.Livre;

public class LivreClient {
	
	private static final String URL_WSDL = "http://localhost:9998/Livre?wsdl";
	
	ILivreDAO livreDAO;
	
	public LivreClient() throws MalformedURLException, JAXBException {
        URL url = new URL(URL_WSDL);
        QName qname = new QName("http://service/", "LivreServiceService");
        Service service = Service.create(url, qname);

        livreDAO = service.getPort(ILivreDAO.class);
	}

	public ILivreDAO getLivreDAO() {
		return livreDAO;
	}

	public void setLivreDAO(ILivreDAO livreDAO) {
		this.livreDAO = livreDAO;
	}
}
