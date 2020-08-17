import java.util.List;

import dao.LivreDao;
import model.Livre;

public class App {

	public static void main(String[] args) {

		LivreDao livDao = new LivreDao();
		
//		----------------------------FINDBYID
		System.out.println("______________________FINDBYID________________________\r");
		Livre l = livDao.findById(1);
		System.out.println(l);
		
//		----------------------------INSERT
		Livre newLivre = new Livre(152, "Zoumbalala", "Prof Madiba");
//		livDao.insert(newLivre);
		
//		----------------------------UPDATE
//		livDao.updateTitreById(5, "Du plaisir dans la cuisine");
//		
//		----------------------------FINDBYTITRE
		System.out.println("______________________FINDBYTITRE________________________\r");
		List<Livre> listByTitre = livDao.findByTitre("Zoumbalala");
		
		for (Livre livre : listByTitre) {
			
			System.out.println(livre);
			
		}
		
//		----------------------------FINDBYAUTEUR
		System.out.println("______________________FINAUTEUR________________________\r");
		List<Livre> listByAuteur = livDao.findByAuteur("Prof Madiba");
		
		for (Livre livre : listByAuteur) {
			
			System.out.println(livre);
			
		}
		
//		----------------------------DELETE
//		livDao.deleteById(152);
		
//		----------------------------FINDALL
		System.out.println("______________________FINDALL________________________\r");
		List<Livre> listLivres = livDao.findAll();
		
		for (Livre livre : listLivres) {
			
			System.out.println(livre + "\r");
			
		}
		
		livDao.closeEmf();
	}

}
