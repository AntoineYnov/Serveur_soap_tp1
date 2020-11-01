package service;

import java.util.List;

import javax.jws.WebService;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.IAuteurDAO;
import entity.Auteur;
import hibernate.HibernateUtil;

@WebService(endpointInterface = "dao.IAuteurDAO")
public class AuteurService implements IAuteurDAO {
	
	SessionFactory sessionFactory  = null;			
    @PersistenceContext
    private Session session = null;	
    
    Transaction transaction = null;
    
    public AuteurService() {
    	session = HibernateUtil.getSessionFactory().openSession();
    	
    	//sessionFactory = HibernateUtil.getSessionFactory();
    	
    	/*if(sessionFactory == null) {
    		session = sessionFactory.openSession();
    	} else  {
    		session = sessionFactory.getCurrentSession();
    	}*/

    }
    
    public void persist(Auteur entity) {
    	transaction = session.beginTransaction();
		session.save(entity);
        transaction.commit();
	}

	public void update(Auteur entity) {
    	transaction = session.beginTransaction();
		session.merge(entity);
        transaction.commit();
	}

	public Auteur findById(int id) {
		return session.find(Auteur.class, id);
	}

	public void delete(Auteur entity) {
    	transaction = session.beginTransaction();
		session.remove(entity);
        transaction.commit();
	}

	public Auteur[] findAll() {
		List<Auteur> listAuteur = session.createQuery("from Auteur",Auteur.class).list();
		Auteur[] auteurs= new Auteur[listAuteur.size()];
		auteurs = listAuteur.toArray(auteurs);
		return auteurs;
	}

	public void deleteAll() {
    	transaction = session.beginTransaction();
		session.createQuery("DELETE FROM Auteur").executeUpdate();
        transaction.commit();
	}
}
