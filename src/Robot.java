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
        super.activeButtonMaxTime.add(Duration.ofSeconds(30));//Entretenir
        super.activeButtonMaxTime.add(Duration.ofSeconds(1800));//Recharger
        super.activeButtonMaxTime.add(Duration.ofSeconds(2));//Débrancher
        super.activeButtonMaxTime.add(Duration.ofSeconds(30));//Nettoyer
        super.activeButtonMaxTime.add(Duration.ofSeconds(30));//Vidanger
        super.activeButtonMaxTime.add(Duration.ofSeconds(120));//Jouer

        //     -----     vitesse modifieur     -----
        super.activeButtonSpeed = new ArrayList<ArrayList<Double>>();
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,50./30,0.,0.,0.,0.)));//Entretenir
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,65./1800,0.,0.,0.)));//Recharger
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,0.,0.,0.,-20./2)));//Débrancher
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,0.,40./30,0.,0.)));//Nettoyer
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,0.,0.,40./30,0.)));//Vidanger
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,-15./120,-15./120,0.,45./120)));//Jouer

        //     -----     vitesse de l'effet du temps     -----
        double s =86400.;//nombre de sec en 24h
        super.CaractTimeSpeed = (new ArrayList<Double>(Arrays.asList(0.,-4/s,-2/s,-4/s,-8/s,-8/s)));
    }
    
}
