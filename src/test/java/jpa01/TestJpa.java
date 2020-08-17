package jpa01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import model.Livre;

public class TestJpa {

	private EntityManagerFactory emf = null;
	
	@Before
	public void init() {

		emf = Persistence.createEntityManagerFactory("pu_essai");
		
	}

	@Test
	public void find() {
		
		EntityManager em = emf.createEntityManager();
		
		if (em != null) {
		
			Livre l = em.find(Livre.class, 1);
			System.out.println(l);
			
		}
		
		em.close();
		emf.close();
		
	}
	
	@Test
	public void findAll() {
		
		EntityManager em = emf.createEntityManager();
		
		if (em != null) {
			
			String requete = "SELECT l FROM Livre l";
			
			TypedQuery<Livre> listLivresFromDB = em.createQuery(requete, Livre.class);
			
			for (Livre l : listLivresFromDB.getResultList()) {
				
				System.out.println(l + "\r");
				
			}
			
		}
		
		em.close();
		emf.close();
		
	}
	
	@Test
	public void findAllById() {
		
		EntityManager em = emf.createEntityManager();
		
		if (em != null) {
			
			String requete = "SELECT l FROM Livre l WHERE l.id = 2";
			
			TypedQuery<Livre> listLivresFromDB = em.createQuery(requete, Livre.class);
			
			for (Livre l : listLivresFromDB.getResultList()) {
				
				System.out.println(l + "\r");
				
			}
			
		}
		
		em.close();
		emf.close();
		
	}
	
//	@Test
//	public void insert() {
//		
//		EntityManager em = emf.createEntityManager();
//		
//		if (em != null) {
//			
//			Livre l = new Livre(6, "Blabla", "Marco Zozo");
//			
////			J'ouvre une transaction
//			em.getTransaction().begin();
//
////			PERSIST pour INSERT			
////			J'ajoute dans la base mon nouveau livre
//			em.persist(l);
//			
////			Je commit
//			em.getTransaction().commit();
//			
//		}
//		
//		em.close();
//		emf.close();
//		
//	}
	
//	@Test
//	public void update() {
//		
//		EntityManager em = emf.createEntityManager();
//		
//		if (em != null) {
//			
////			J'ouvre une transaction
//			em.getTransaction().begin();
//			
////			Je vais chercher un livre en DB et je le modifie
//			Livre l = em.find(Livre.class, 6);
//			l.setTitre("Oiseau ballon");
//			
////			MERGE pour UPDATE
////			J'ajoute dans la base mon nouveau livre
//			em.merge(l);
//			
////			Je commit
//			em.getTransaction().commit();
//			
//		}
//		
//		em.close();
//		emf.close();
//		
//	}
	
	@Test
	public void delete() {
		
		EntityManager em = emf.createEntityManager();
		
		if (em != null) {
			
//			J'ouvre une transaction
			em.getTransaction().begin();
			
//			Je vais chercher un livre en DB et je le modifie
			Livre l = em.find(Livre.class, 6);
			
//			MERGE pour UPDATE
//			Je supprime de la base le livre 6
			em.remove(l);
			
//			Je commit
			em.getTransaction().commit();
			
		}
		
		em.close();
		emf.close();
		
	}

}
