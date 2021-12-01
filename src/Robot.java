import java.util.ArrayList;
import java.util.Arrays;


public class Robot extends Personnage{
    
    Robot(String n)
    {
        super(n);
        super.type=3;
        super.nomCaracteristiques=new ArrayList<>(Arrays.asList("Vie","Integrité","Batterie","Propreté","Huile","Moral"));
    }
    
}
