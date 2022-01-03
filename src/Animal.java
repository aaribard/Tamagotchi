import java.util.ArrayList;
import java.util.Arrays;

public class Animal extends Personnage{
    Animal(String n)
    {
        super(n);
        super.nomActions=new ArrayList<String>(Arrays.asList("Manger", "Dormir", "Reveiller","Se laver","Toilettes","Jouer"));
        super.nomCaracteristiques=new ArrayList<String>(Arrays.asList("Vie", "Nourriture", "Energie","Hygiène","Toilettes","Moral"));
        super.fichiersCaracteristiques=new ArrayList<String>(Arrays.asList("img/LogoBarres/vieLogo.png","img/LogoBarres/nourritureLogo.png","img/LogoBarres/energieLogo.png","img/LogoBarres/hygieneLogo.png","img/LogoBarres/toilettesLogo.png","img/LogoBarres/moralLogo.png"));
        super.fichiersPieces=new ArrayList<String>(Arrays.asList("img/Pieces/salonFond.png","img/Pieces/cuisineFond.png","img/Pieces/chambreFond.png","img/Pieces/sdbFond.png","img/Pieces/toilettesFond.png","img/Pieces/jardinFond.png"));
    }
}
