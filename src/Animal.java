import java.util.ArrayList;
import java.util.Arrays;


public class Animal extends Personnage{
    Animal(String n)
    {
        super(n);
        super.nomCaracteristiques=new ArrayList<String>(Arrays.asList("Vie", "Nourriture", "Energie","Hygiène","Toilettes","Moral"));
        super.fichiersCaracteristiques=new ArrayList<String>(Arrays.asList("img/LogoBarres/vieLogo.png","img/LogoBarres/nourritureLogo.png","img/LogoBarres/energieLogo.png","img/LogoBarres/hygieneLogo.png","img/LogoBarres/toilettesLogo.png","img/LogoBarres/moralLogo.png"));
    }
    
}
