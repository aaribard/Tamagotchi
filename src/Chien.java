import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
public class Chien extends Animal{
    Chien(String n)
    {
        super(n);
        super.type=0;
        super.fichiersPersonnages=new ArrayList<String>(Arrays.asList("img/Personnages/chien.gif","img/Personnages/chienDodo.gif"));

        //     -----     duree max modifieur     -----
        super.activeButtonMaxTime = new ArrayList<Duration>();
        super.activeButtonMaxTime.add(Duration.ofSeconds(30));//manger
        super.activeButtonMaxTime.add(Duration.ofSeconds(1800));//dormir
        super.activeButtonMaxTime.add(Duration.ofSeconds(2));//reveiller
        super.activeButtonMaxTime.add(Duration.ofSeconds(30));//laver
        super.activeButtonMaxTime.add(Duration.ofSeconds(30));//toilettes
        super.activeButtonMaxTime.add(Duration.ofSeconds(120));//jouer

        //     -----     vitesse modifieur     -----
        super.activeButtonSpeed = new ArrayList<ArrayList<Double>>();
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,50./30,0.,0.,0.,0.)));//manger
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,65./1800,0.,0.,0.)));//dormir
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,0.,0.,0.,-10./2)));//reveiller +
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,0.,40./30,0.,0.)));//laver
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,0.,0.,40./30,0.)));//toilettes
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,-20./120,-20./120,0.,60./120)));//jouer .--.+

        //     -----     vitesse de l'effet du temps     -----
        double s =86400.;//nombre de sec en 24h
        super.CaractTimeSpeed = (new ArrayList<Double>(Arrays.asList(0.,-6/s,-2/s,-4/s,-8/s,-6/s)));//manger +
    }
    
}