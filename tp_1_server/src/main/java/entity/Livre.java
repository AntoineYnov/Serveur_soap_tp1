package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="livre")
@XmlRootElement
public class Livre implements Serializable {

	/**
	 * 	
	 */
	private static final long serialVersionUID = 1L;

	 @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private int id;

     @Column(name="nom", length=50)
     private String nom ;

     
     @ManyToMany(cascade=CascadeType.ALL)
     @OrderColumn
     private Auteur[] auteur;
     
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Auteur[] getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur[] auteur) {
		this.auteur = auteur;
	}
}
