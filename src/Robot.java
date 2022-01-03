import java.util.ArrayList;
import java.util.Arrays;
import java.time.Duration;

public class Robot extends Personnage{
    
    Robot(String n)
    {
        super(n);
        super.type=3;
        super.nomActions=new ArrayList<String>(Arrays.asList("Entretenir", "Recharger", "Débrancher","Nettoyer","Vidanger","Jouer"));
        super.nomCaracteristiques=new ArrayList<String>(Arrays.asList("Vie","Integrité","Batterie","Propreté","Huile","Moral"));
        super.fichiersCaracteristiques=new ArrayList<String>(Arrays.asList("img/LogoBarres/vie2Logo.png","img/LogoBarres/integriteLogo.png","img/LogoBarres/batterieLogo.png","img/LogoBarres/propreteLogo.png","img/LogoBarres/huileLogo.png","img/LogoBarres/moralLogo.png"));
        super.fichiersPersonnages=new ArrayList<String>(Arrays.asList("img/Personnages/robot.gif","img/Personnages/robotDodo.gif"));
        super.fichiersPieces=new ArrayList<String>(Arrays.asList("img/Pieces/courFond.png","img/Pieces/atelierFond.png","img/Pieces/centraleFond.png","img/Pieces/stationFond.png","img/Pieces/garageFond.png","img/Pieces/salleFond.png"));
        //     -----     duree max modifieur     -----
        super.activeButtonMaxTime = new ArrayList<Duration>();
        super.activeButtonMaxTime.add(Duration.ofSeconds(3));//Vie
        super.activeButtonMaxTime.add(Duration.ofSeconds(40));//Integrité
        super.activeButtonMaxTime.add(Duration.ofSeconds(1));//Batterie
        super.activeButtonMaxTime.add(Duration.ofSeconds(10));//Propreté
        super.activeButtonMaxTime.add(Duration.ofSeconds(10));//Huile
        super.activeButtonMaxTime.add(Duration.ofSeconds(20));//Moral

        //     -----     vitesse modifieur     -----
        super.activeButtonSpeed = new ArrayList<ArrayList<Double>>();
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,15.,0.,0.,0.,0.)));//Vie
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,2.,0.,0.,0.)));//Integrité
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,0.,0.,0.,-15.)));//Batterie
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,0.,5.,0.,0.)));//Propreté
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,0.,0.,5.,0.)));//Huile
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,-1.,-1.,0.,3.)));//Moral

        //     -----     vitesse de l'effet du temps     -----
        super.CaractTimeSpeed = (new ArrayList<Double>(Arrays.asList(0.,-0.1,-0.1,-0.1,-0.1,-0.1)));
    }
    
}
