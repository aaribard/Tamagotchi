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
        super.activeButtonMaxTime.add(Duration.ofSeconds(3));//manger
        super.activeButtonMaxTime.add(Duration.ofSeconds(40));//dormir
        super.activeButtonMaxTime.add(Duration.ofSeconds(1));//reveiller
        super.activeButtonMaxTime.add(Duration.ofSeconds(10));//laver
        super.activeButtonMaxTime.add(Duration.ofSeconds(10));//toilettes
        super.activeButtonMaxTime.add(Duration.ofSeconds(20));//jouer

        //     -----     vitesse modifieur     -----
        super.activeButtonSpeed = new ArrayList<ArrayList<Double>>();
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,15.,0.,0.,0.,0.)));//manger
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,2.,0.,0.,0.)));//dormir
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,0.,0.,0.,-10.)));//reveiller +
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,0.,5.,0.,0.)));//laver
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,0.,0.,5.,0.)));//toilettes
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,-1.5,-1.5,0.,3.)));//jouer .--.+

        //     -----     vitesse de l'effet du temps     -----
        super.CaractTimeSpeed = (new ArrayList<Double>(Arrays.asList(0.,-0.2,-0.1,-0.1,-0.1,-0.1)));//manger +
    }
    
}