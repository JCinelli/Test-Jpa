import java.util.List;
import java.util.Set;

import dao.EmpruntDao;
import dao.LivreDao;
import model.Emprunt;
import model.Livre;

public class App {

	public static void main(String[] args) {

//		LivreDao livDao = new LivreDao();
//		___________________________________________________________________________________________________________
//		_________________________________________________LIVRE____________________________________________________
//		___________________________________________________________________________________________________________
		
//		----------------------------FINDBYID
//		System.out.println("______________________FINDBYID________________________\r");
//		Livre l = livDao.findById(1);
//		System.out.println(l);
		
//		----------------------------INSERT
//		Livre newLivre = new Livre(152, "Zoumbalala", "Prof Madiba");
//		livDao.insert(newLivre);
		
//		----------------------------UPDATE
//		livDao.updateTitreById(5, "Du plaisir dans la cuisine");
//		
//		----------------------------FINDBYTITRE
//		System.out.println("______________________FINDBYTITRE________________________\r");
//		List<Livre> listByTitre = livDao.findByTitre("Zoumbalala");
//		
//		for (Livre livre : listByTitre) {
//			
//			System.out.println(livre);
//			
//		}
		
//		----------------------------FINDBYAUTEUR
//		System.out.println("______________________FINAUTEUR________________________\r");
//		List<Livre> listByAuteur = livDao.findByAuteur("Prof Madiba");
//		
//		for (Livre livre : listByAuteur) {
//			
//			System.out.println(livre);
//			
//		}
		
//		----------------------------DELETE
//		livDao.deleteById(152);
		
//		----------------------------FINDALL
//		System.out.println("______________________FINDALL________________________\r");
//		List<Livre> listLivres = livDao.findAll();
//		
//		for (Livre livre : listLivres) {
//			
//			System.out.println(livre + "\r");
//			
//		}
//		
//		livDao.closeEmf();
		
//		___________________________________________________________________________________________________________
//		_________________________________________________EMPRUNT____________________________________________________
//		___________________________________________________________________________________________________________
		
		EmpruntDao empDao = new EmpruntDao();

////		Réalisez une requête qui permet d’extraire un emprunt et tous ses livres associés.
//		Set<Livre> livres = empDao.findLivresByEmpruntId(1);
//		
//		System.out.println("\r---- Les livres pour l'emprunt d'Id 1 sont : ---- \r");
//		
//		for (Livre livre : livres) {
//			
//			System.out.println(livre + "\r");
//			
//		}
		
//		Réalisez une requête qui permet d’extraire tous les emprunts d’un client donné.
		List<Emprunt> listEmpruntByClient = empDao.findEmpruntByClientId(1);
		
		System.out.println("\r---- Le client d'Id 1, à emprunté : ----\r ");
		
		for (Emprunt emprunt : listEmpruntByClient) {
			
			Set<Livre> listLivresEmprunt = emprunt.getLivres();
			
			System.out.println(" Emprunt " + emprunt.getId() + " :");
			
			for (Livre livre : listLivresEmprunt) {
				
				System.out.println("  " + livre.getTitre());
				
			}
			
			System.out.print("\r");
			
		}
		
		empDao.closeEmf();
	}

}
