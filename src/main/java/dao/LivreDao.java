package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Livre;

public class LivreDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_essai");

	public Livre findById(int id) {

		EntityManager em = emf.createEntityManager();

		Livre l = null;

		if (em != null) {

			l = em.find(Livre.class, id);

			if (l != null) {

				return l;

			} else {

				System.out.println("!!! Le livre d'Id : " + id + " est introuvable .. !!! ");

			}

		}

		em.close();

		return l;
	}

	public void insert(Livre newLivre) {

		EntityManager em = emf.createEntityManager();

		if (em != null) {

//			J'ouvre une transaction
			em.getTransaction().begin();

			if (newLivre != null) {

//			PERSIST pour INSERT			
//			J'ajoute dans la base mon nouveau livre
				em.persist(newLivre);

			}

//			Je commit
			em.getTransaction().commit();

		}

		em.close();

	}

	public void updateTitreById(int id, String choseARemplacer) {

		EntityManager em = emf.createEntityManager();

		if (em != null) {

//			J'ouvre une transaction
			em.getTransaction().begin();

//			Je vais chercher un livre en DB et je le modifie
			Livre l = em.find(Livre.class, id);

			if (l != null) {

				l.setTitre(choseARemplacer);

//				MERGE pour UPDATE
//				J'ajoute dans la base mon nouveau livre
				em.merge(l);

//				Je commit
				em.getTransaction().commit();

			} else {

				System.out.println("!!! Le livre d'Id : " + id + " est introuvable .. !!! ");

			}

		}

		em.close();

	}

	public List<Livre> findAll() {

		EntityManager em = emf.createEntityManager();
		List<Livre> listRetour = new ArrayList<Livre>();

		if (em != null) {

			String requete = "SELECT l FROM Livre l";

			TypedQuery<Livre> listLivresFromDB = em.createQuery(requete, Livre.class);

			listRetour = listLivresFromDB.getResultList();

		}

		em.close();
		
		return listRetour;
	}

	public List<Livre> findByTitre(String titre) {

		EntityManager em = emf.createEntityManager();
		List<Livre> listRetour = new ArrayList<Livre>();

		if (em != null) {

			String requete = "SELECT l FROM Livre l WHERE l.titre = '" + titre + "'";

			TypedQuery<Livre> listLivresFromDB = em.createQuery(requete, Livre.class);

			listRetour = listLivresFromDB.getResultList();

		}

		if (listRetour.size() == 0) {

			System.out.println("!!! Aucun livre trouvé avec ce titre : " + titre + " !!!");

		}

		em.close();

		return listRetour;
	}

	public List<Livre> findByAuteur(String auteur) {

		EntityManager em = emf.createEntityManager();
		List<Livre> listRetour = new ArrayList<Livre>();

		if (em != null) {

			String requete = "SELECT l FROM Livre l WHERE l.auteur = '" + auteur + "'";

			TypedQuery<Livre> listLivresFromDB = em.createQuery(requete, Livre.class);

			listRetour = listLivresFromDB.getResultList();

		}

		if (listRetour.size() == 0) {

			System.out.println("!!! Aucun livre trouvé avec cet auteur : " + auteur + " !!!");

		}

		em.close();

		return listRetour;
	}

	public void deleteById(int id) {

		EntityManager em = emf.createEntityManager();

		if (em != null) {

//			J'ouvre une transaction
			em.getTransaction().begin();

//			Je vais chercher un livre en DB et je le modifie
			Livre l = em.find(Livre.class, id);

			if (l != null) {

//				REMOVE pour DELETE
//				Je supprime de la base le livre 6
				em.remove(l);

//				Je commit
				em.getTransaction().commit();

			}

		}

		em.close();

	}
	
	public void closeEmf() {
		emf.close();
	}

}
