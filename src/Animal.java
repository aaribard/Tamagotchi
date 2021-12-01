import java.util.ArrayList;
import java.util.Arrays;


public class Animal extends Personnage{
    Animal(String n)
    {
        super(n);
        super.nomCaracteristiques=new ArrayList<>(Arrays.asList("Vie", "Nourriture", "Energie","Hygiène","Toilettes","Moral"));
    }
    
}
