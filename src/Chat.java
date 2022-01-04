import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
public class Chat extends Animal{
    Chat(String n)
    {
        super(n);
        super.type=1;
        super.fichiersPersonnages=new ArrayList<String>(Arrays.asList("img/Personnages/chat.gif","img/Personnages/chatDodo.gif"));

        //     -----     duree max modifieur     -----
        super.activeButtonMaxTime = new ArrayList<Duration>();
        super.activeButtonMaxTime.add(Duration.ofSeconds(30));//manger
        super.activeButtonMaxTime.add(Duration.ofSeconds(1800));//dormir
        super.activeButtonMaxTime.add(Duration.ofSeconds(2));//reveiller
        super.activeButtonMaxTime.add(Duration.ofSeconds(20));//laver -
        super.activeButtonMaxTime.add(Duration.ofSeconds(20));//toilettes -
        super.activeButtonMaxTime.add(Duration.ofSeconds(120));//jouer

        //     -----     vitesse modifieur     -----
        super.activeButtonSpeed = new ArrayList<ArrayList<Double>>();
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,50./30,0.,0.,0.,0.)));//manger
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,65./1800,0.,0.,0.)));//dormir
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,0.,0.,0.,-30./2)));//reveiller -
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,0.,40./30,0.,0.)));//laver
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,0.,0.,40./30,0.)));//toilettes
        super.activeButtonSpeed.add(new ArrayList<Double>(Arrays.asList(0.,0.,-8./120,-8./120,0.,45./120)));//jouer .++..

        //     -----     vitesse de l'effet du temps     -----
        double s =86400.;//nombre de sec en 24h
        super.CaractTimeSpeed = (new ArrayList<Double>(Arrays.asList(0.,-4/s,-4/s,-4/s,-8/s,-6/s)));//dormir +
    }
}