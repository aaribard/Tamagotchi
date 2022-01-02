import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Jeu {
	private ArrayList<Piece> pieces;
	private Personnage perso;
	private FenetreCreation fenCreat;
    private FenetreJeu fenJeu;
	Jeu()
	{
		
		//FenetreLancement f=new FenetreLancement();
		//perso=Sauvegarde.charger();
		perso=new Chien("Pipou");
		pieces=new ArrayList<Piece>();
		initPieces();
		fenJeu=new FenetreJeu(perso, pieces);
		//Sauvegarde.sauvegarder(perso);
		//initPerso();
		simulation();
	}
	public void initPieces()
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
		pieces.get(0).addPieceAdja(pieces.get(4));
		pieces.get(0).addPieceAdja(pieces.get(5));

		//cuisine
		pieces.get(1).addPieceAdja(pieces.get(0));


		//chambre
		pieces.get(2).addPieceAdja(pieces.get(0));
		pieces.get(2).addPieceAdja(pieces.get(3));


		//salle de bain
		pieces.get(3).addPieceAdja(pieces.get(2));

		//toilettes
		pieces.get(4).addPieceAdja(pieces.get(0));

		//jardin
		pieces.get(5).addPieceAdja(pieces.get(0));
	}

	public void initPerso()
	{
		fenCreat= new FenetreCreation();
		while(fenCreat.getActive())
		{	try
			{
				Thread.sleep(20);
			}
			catch(InterruptedException ex)
			{
				Thread.currentThread().interrupt();
			}
		}
		perso = fenCreat.getPersonnage();
		System.out.println(perso.getNom());
	}
	public void changerPiece(Personnage perso, Piece p)
	{
		if(perso.getPiece()!=p.getId())
		{
			for(int i=0;i<p.getNbPieces();i++)
			{
				if(perso.getPiece()==p.getPieceAdja().get(i).getId())
				{
					perso.setPiece(p.getId());
					break;
				}
			}
		}
	}
	public void interact()
	{
		ArrayList<Boolean> b=fenJeu.getBoutonAppuye();
		fenJeu.resetBoutonAppuye();
		perso.setAllCaracteristiques(b);

		if(fenJeu.getBoutonSauvegarde())
		{
			Sauvegarde.sauvegarder(perso);
			fenJeu.resetBoutonSauvegarde();
		}
	}

	private void simulation()
	{
		for(int i=0;i<1200;i++)
		{
			System.out.println(i);
			interact();
			fenJeu.refresh(perso);


			//bouton Quitter
			if(fenJeu.getBoutonQuitter())
			{
				break;
			}
			//temporisation
			try
			{
				TimeUnit.MILLISECONDS.sleep(50);
			}
			catch (InterruptedException a)
			{
				System.out.println("Interruption");
			}
		}
	}
}
