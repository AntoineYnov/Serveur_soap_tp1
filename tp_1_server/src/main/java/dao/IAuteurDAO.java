package dao;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import entity.Auteur;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL)
public interface IAuteurDAO {

	@WebMethod
    public void persist(@WebParam(name="Auteur") Auteur entity);
    
	@WebMethod
    public void update(@WebParam(name="Auteur") Auteur entity);
     
	@WebMethod
    public Auteur findById(@WebParam(name="id") int id);
    
	@WebMethod
    public void delete(@WebParam(name="Auteur") Auteur entity);
     
	@WebMethod
    public Auteur[] findAll();
    
	@WebMethod
    public void deleteAll();

}
