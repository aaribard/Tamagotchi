import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Jeu {
	private ArrayList<Piece> pieces;
	private Personnage perso;
	private FenetreLancement fenLanc;
	private FenetreCreation fenCreat;
    private FenetreJeu fenJeu;

	Jeu()
	{
		pieces=new ArrayList<Piece>();
		initPieces();

		lancement();
	}
	private void initPieces()
	{
		pieces.add(new Piece("salon"));
		pieces.add(new Piece("cuisine"));
		pieces.add(new Piece("chambre"));
		pieces.add(new Piece("salle de bain"));
		pieces.add(new Piece("toilettes"));
		pieces.add(new Piece("jardin"));

		//salon
		pieces.get(0).addPieceAdja(pieces.get(1));
		pieces.get(0).addPieceAdja(pieces.get(2));
		pieces.get(0).addPieceAdja(pieces.get(3));
		pieces.get(0).addPieceAdja(pieces.get(4));
		pieces.get(0).addPieceAdja(pieces.get(5));

		//cuisine
		pieces.get(1).addPieceAdja(pieces.get(0));

		//chambre
		pieces.get(2).addPieceAdja(pieces.get(0));

		//salle de bain
		pieces.get(3).addPieceAdja(pieces.get(0));

		//toilettes
		pieces.get(4).addPieceAdja(pieces.get(0));

		//jardin
		pieces.get(5).addPieceAdja(pieces.get(0));
	}

	private void initPerso()
	{
		fenCreat= new FenetreCreation();
		while(fenCreat.getActive())
		{	try
			{
				TimeUnit.MILLISECONDS.sleep(50);
			}
			catch (InterruptedException a)
			{
				System.out.println("Interruption");
			}
		}
		perso = fenCreat.getPersonnage();
		Sauvegarde.sauvegarder(perso);
	}

	private void lancement()
	{
		fenLanc=new FenetreLancement();
		while(fenLanc.getActive()==true)//boucle qui attend la fermeture de la fenetre de lancement
		{
			try
			{
				TimeUnit.MILLISECONDS.sleep(50);
			}
			catch (InterruptedException a)
			{
				System.out.println("Interruption");
			}
		}
		if(fenLanc.getFermeture()==1)//fenetre de lancement fermée avec le bouton QUITTER
		{
			System.out.println("Fermeture Bouton Quitter");
		}
		else if(fenLanc.getFermeture()==2)//fenetre de lancement fermée pour lancer une NOUVELLE PARTIE
		{
			System.out.println("Nouvelle Partie");
			initPerso();
			fenJeu=new FenetreJeu(perso, pieces);
			simulation();
		}
		else if(fenLanc.getFermeture()==3)//fenetre de lancement fermée pour CHARGER une PARTIE EXISTANTE
		{
			System.out.println("Charger Partie - "+fenLanc.getFileToStart());
			perso=Sauvegarde.charger(fenLanc.getFileToStart());
			fenJeu=new FenetreJeu(perso, pieces);
			simulation();
		}
	}

	private void interact()//lecture des boutons appuyés et calcul des nouvelles valeurs des caracteristiques
	{
		ArrayList<Boolean> b=fenJeu.getBoutonAppuye();
		fenJeu.resetBoutonAppuye();

		perso.setAllCaracteristiques(b);

		if(fenJeu.getBoutonSauvegarde())//sauvegarde demandée
		{
			Sauvegarde.sauvegarder(perso);
			fenJeu.resetBoutonSauvegarde();
		}
	}

	private void simulation()
	{
		while(fenJeu.getBoutonQuitter()==false)	//boucle qui attend que le jeu soit quitté
		{
			interact();							//lecture des boutons et calculs caracteristiques
			fenJeu.refresh(perso);				//actualisation du visuel

			//temporisation 50ms
			try
			{
				TimeUnit.MILLISECONDS.sleep(50);
			}
			catch (InterruptedException a)
			{
				System.out.println("Interruption");
			}
		}
		Sauvegarde.sauvegarder(perso);			//sauvegarde quand le joueur quitte
	}
}
