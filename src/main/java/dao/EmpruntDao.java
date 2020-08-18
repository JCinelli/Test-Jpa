package dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Emprunt;
import model.Livre;

public class EmpruntDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_essai");
	
	public Emprunt findById(int id) {

		EntityManager em = emf.createEntityManager();

		Emprunt emprunt = null;

		if (em != null) {

			emprunt = em.find(Emprunt.class, id);

			if (emprunt == null) {

				System.out.println("!!! L'emprunt d'Id : " + id + " est introuvable .. !!! ");
				return null;
				
			}

		}

		em.close();

		return emprunt;
	}
	
	public Set<Livre> findLivresByEmpruntId(int idEmprunt) {

		EntityManager em = emf.createEntityManager();

		Set<Livre> listLivreEmprunt = new HashSet<Livre>();
		

		if (em != null) {
			
			Emprunt emprunt = findById(idEmprunt);
			
			if (emprunt != null) {
			
				listLivreEmprunt = emprunt.getLivres();
				
			}

		}

		em.close();
		
		if (listLivreEmprunt.isEmpty()) {

			System.out.println("!!! L'emprunt d'Id : " + idEmprunt + " est introuvable .. !!! ");
			return null;

		}

		return listLivreEmprunt;
	}
	
	public List<Emprunt> findEmpruntByClientId(int idClient) {

		EntityManager em = emf.createEntityManager();

		List<Emprunt> listEmpruntClient = new ArrayList<Emprunt>();
		

		if (em != null) {
			
			String requete =  "SELECT e FROM Emprunt e WHERE e.client.id = " + idClient;
			
			TypedQuery<Emprunt> listEmpruntClientFromDB = em.createQuery(requete, Emprunt.class);
			
			listEmpruntClient = listEmpruntClientFromDB.getResultList();

		}

		em.close();
		
		if (listEmpruntClient.isEmpty()) {

			System.out.println("!!! Le client d'Id : " + idClient + " est introuvable ou il n'a jamais fait d'emprunt.. !!! ");
			return null;

		}

		return listEmpruntClient;
	}
	
	public void closeEmf() {
		emf.close();
	}
	
}
