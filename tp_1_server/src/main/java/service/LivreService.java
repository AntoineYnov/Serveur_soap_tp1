package service;

import java.util.List;

import javax.jws.WebService;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.ILivreDAO;
import entity.Livre;
import hibernate.HibernateUtil;

@WebService(endpointInterface = "dao.ILivreDAO")
public class LivreService implements ILivreDAO{
	  @PersistenceContext
	    private Session session = null;
	    
	    Transaction transaction = null;
	    
	    public LivreService() {
			session = HibernateUtil.getSessionFactory().openSession();
	    }

	    public void persist(Livre entity) {
	    	transaction = session.beginTransaction();
			session.save(entity);
	        transaction.commit();
		}

		public void update(Livre entity) {
	    	transaction = session.beginTransaction();
			session.merge(entity);
	        transaction.commit();
		}

		public Livre findById(int id) {
			return session.find(Livre.class, id);
		}

		public void delete(Livre entity) {
	    	transaction = session.beginTransaction();
			session.remove(entity);
	        transaction.commit();
		}

		public Livre[] findAll() {
			List<Livre> listLivre = session.createQuery("from Livre",Livre.class).list();
			Livre[] livres = new Livre[listLivre.size()];
			livres = listLivre.toArray(livres);
			return livres;
		}

		public void deleteAll() {
	    	transaction = session.beginTransaction();
	    	session.createQuery("DELETE FROM Livre").executeUpdate();
	        transaction.commit();
		}
}