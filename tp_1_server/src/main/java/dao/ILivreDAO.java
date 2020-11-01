package dao;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import entity.Livre;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL) 
public interface ILivreDAO {
	
	@WebMethod
    public void persist(Livre entity);
    
	@WebMethod
    public void update(Livre entity);
     
	@WebMethod
    public Livre findById(int id);
    
	@WebMethod
    public void delete(Livre entity);
     
	@WebMethod
    public Livre[] findAll();
    
	@WebMethod
    public void deleteAll();
}
