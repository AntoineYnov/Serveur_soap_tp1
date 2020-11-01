package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="auteur")
@XmlRootElement
public class Auteur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private int id;

     @Column(name="family_name", length=50)
     private String nom ;

     @Column(name="first_name", length=50)
     private String prenom ;

     private  int age ;
     
	 @ManyToMany(cascade=CascadeType.ALL)
	 @JoinTable(
	     name = "Auteur_Livre", 
	     joinColumns = { @JoinColumn(name = "auteur_id") }, 
	     inverseJoinColumns = { @JoinColumn(name = "livre_id") }
	 )
     @OrderColumn
     private Livre[] livres;

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Livre[] getLivres() {
		return livres;
	}

	public void setLivres(Livre[] livres) {
		this.livres = livres;
	}
}
