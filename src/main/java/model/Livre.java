package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "livre")
public class Livre {

	@Id
	private int id;

	@Column (name = "TITRE", length = 255, nullable = false)
	private String titre;

	@Column (name = "AUTEUR", length = 50, nullable = false)
	private String auteur;
	
	@ManyToMany ( mappedBy = "livres")
	private Set<Emprunt> emprunts;

	
//	CONSTRUCTORS
	public Livre() {
		super();
	}

	public Livre(int id, String titre, String auteur) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
	}

//	METHODS
	@Override
	public String toString() {
		return "Livre : \r Id : " + id + "\r Titre : " + titre + "\r Auteur : " + auteur;
	}

	
//	GETTERS & SETTERS
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the prenom
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the nom
	 */
	public String getAuteur() {
		return auteur;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

}
