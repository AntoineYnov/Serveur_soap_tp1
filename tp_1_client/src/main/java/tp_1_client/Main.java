package tp_1_client;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import dao.IAuteurDAO;
import dao.ILivreDAO;
import entity.Auteur;
import entity.Livre;


public class Main {

	   public static void main(String[] args) throws MalformedURLException, JAXBException {
		   
		   // COMMENTAIRE RESUME DE LA OU J'EN SUIS
		   
		   // ME MANQUE LES JSP
		   
		   // RELANCER A CHAQUE FOIS LE SERVEUR AVANT DE LANCER UNE NOUVELLE FOIS CE MAIN
		   // ERREUR CAR JE RECREE DES OBJETS DE MEME VALEUR QUE LA SESSION PRECEDENTES
		   // HORS CE PROBLEME TOUTES MES REQUETES FONCTIONNENT
		   
		   AuteurClient auteurClient = new AuteurClient();
		   LivreClient livreClient = new LivreClient();
		   
		   IAuteurDAO auteurDAO = auteurClient.getAuteurDAO();
		   ILivreDAO livreDAO = livreClient.getLivreDAO();
		   
		   // DELETE ALL OCCURENCES
		   auteurDAO.deleteAll();
		   livreDAO.deleteAll();
			
			JAXBContext context = JAXBContext.newInstance(Auteur.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			Livre[] livreAntoine = new Livre[3];
			
			List<Livre> listeLivre = new ArrayList<Livre>();
			
	        Livre livre1 = new Livre();
	        livre1.setNom("LOTR");
	        livre1.setId(1);
	        
	        Livre livre2 = new Livre();
	        livre2.setNom("Harry potter");
	        livre2.setId(2);
	        
	        Livre livre3 = new Livre();
	        livre3.setNom("Monsieur");
	        livre3.setId(3);
	       
	        
			listeLivre.add(livre1);
			listeLivre.add(livre2);
			listeLivre.add(livre3);

			livreAntoine = listeLivre.toArray(livreAntoine);
			
			Auteur auteur1 = new Auteur();
			auteur1.setId(4);
			auteur1.setAge(23);
			auteur1.setNom("GENOUIN-DUHAMEL");
			auteur1.setPrenom("Antoine");
			auteur1.setLivres(livreAntoine);
			
			Auteur auteur2 = new Auteur();
			auteur2.setId(5);
			auteur2.setAge(18);
			auteur2.setNom("NOUKEU");
			auteur2.setPrenom("Samory");
			
			Auteur auteur3 = new Auteur();
			auteur3.setId(6);
			auteur3.setAge(99);
			auteur3.setNom("DUPONT");
			auteur3.setPrenom("MALO");
			

			marshaller.marshal(auteur1, System.out);
			marshaller.marshal(auteur2, System.out);
			marshaller.marshal(auteur3, System.out);
			
			marshaller.marshal(livre1, System.out);
			marshaller.marshal(livre2, System.out);
			marshaller.marshal(livre3, System.out);
			
			// AJOUT OCCURENCES
	        livreDAO.persist(livre1);
	        livreDAO.persist(livre2);
	        livreDAO.persist(livre3);
	        
			auteurDAO.persist(auteur1);
			auteurDAO.persist(auteur2);
			auteurDAO.persist(auteur3);
	        
			// FINDALL OCCURENCES
			Auteur[] auteurs = auteurDAO.findAll();
	        Livre[] livres = livreDAO.findAll();
			
			for(Livre livre : livres ) {
				System.out.println("Livre : " + livre.getId() + "-> " + livre.getNom() + " ");
			}

			for(Auteur auteur : auteurs ) {
				System.out.println("Auteur : " + auteur.getId() + " -> " + auteur.getNom() + " " + auteur.getPrenom());
			}

	        // UPDATE OCCURENCE 
	        livre2.setNom("Harry Potter vs Voldemort");
	        livreDAO.update(livre2);
	        
			// FIND ONE OCCURENCE
			Livre livreFindOne = livreDAO.findById(2);
			System.out.println("Livre updated : " + livreFindOne.getId() + "-> " + livreFindOne.getNom() + " ");
			
			Auteur auteurFindOne = auteurDAO.findById(4);
			System.out.println("Auteur : " +auteurFindOne.getId() + "-> " + auteurFindOne.getNom() + " " + auteurFindOne.getPrenom());
	    }
}
