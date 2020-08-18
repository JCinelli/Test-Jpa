package model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "emprunt")
public class Emprunt {

	@Id
	private int id;
	
	@Column (name = "DATE_DEBUT", nullable = false)
	private LocalDateTime dateDebut;
	
	@Column (name = "DATE_FIN", nullable = true)
	private LocalDateTime dateFin;
	
	@Column (name = "DELAI", nullable = true)
	private int delai;
	
	@ManyToOne
	@JoinColumn (name = "ID_CLIENT")
	private Client client;
	
	@ManyToMany (fetch = FetchType.EAGER)
	@JoinTable ( name = "COMPO",
			joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))
	private Set<Livre> livres;

	
//	CONSTRUCTORS
	public Emprunt() {
		super();
	}


	public Emprunt(int id, LocalDateTime dateDebut, LocalDateTime dateFin, int delai, Client client) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.delai = delai;
		this.client = client;
	}


//	METHODS
	@Override
	public String toString() {
		return "Emprunt :\r Id : " + id + "\r Date de debut : " + dateDebut + "\r Date de fin : " + dateFin + "\r Delai : " + delai
				+ "\r " + client + "\r " + livres;
	}


//	GETTERS & SETTERS
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the dateDebut
	 */
	public LocalDateTime getDateDebut() {
		return dateDebut;
	}


	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}


	/**
	 * @return the dateFin
	 */
	public LocalDateTime getDateFin() {
		return dateFin;
	}


	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}


	/**
	 * @return the delai
	 */
	public int getDelai() {
		return delai;
	}


	/**
	 * @param delai the delai to set
	 */
	public void setDelai(int delai) {
		this.delai = delai;
	}


	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}


	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}


	/**
	 * @return the livres
	 */
	public Set<Livre> getLivres() {
		return livres;
	}


	/**
	 * @param livres the livres to set
	 */
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
	
	
}
