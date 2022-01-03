import java.io.*;
import java.util.ArrayList;

public class Sauvegarde {
    public static void sauvegarder(Personnage perso)
    {
         try{
                String nomFichier = perso.getNom()+"_"+perso.getDateNaissanceListe().get(2)+"_"+perso.getDateNaissanceListe().get(1)+"_"+perso.getDateNaissanceListe().get(0)+".txt";
                PrintWriter txtSauv = new PrintWriter(new FileWriter("save/"+nomFichier));
                ArrayList<Integer> dateNaissance=perso.getDateNaissanceListe();
                txtSauv.println(perso.getNom());
                txtSauv.println(perso.getType());
                txtSauv.println(dateNaissance.get(0));
                txtSauv.println(dateNaissance.get(1));
                txtSauv.println(dateNaissance.get(2));
                txtSauv.println(perso.getCaracteristiqueString());
                txtSauv.println(perso.getPiece());
                txtSauv.flush();
                txtSauv.close();
            }
            catch (java.io.IOException e) {e.printStackTrace();}
    }
   
    public static Personnage charger(String fileName)
    {
        BufferedReader lect ;
        Personnage perso;
        try
        {
            lect = new BufferedReader(new FileReader("save/"+fileName)) ;
            String nom=lect.readLine();
            int type=Integer.parseInt(lect.readLine());
            int annee=Integer.parseInt(lect.readLine());
            int mois=Integer.parseInt(lect.readLine());
            int jour=Integer.parseInt(lect.readLine());
            String caracteristiqueString=lect.readLine();
            int piece=Integer.parseInt(lect.readLine());
            perso=choixType(type,nom);
            perso.setDateNaissance(annee, mois, jour);
            String[] splitted = caracteristiqueString.split(" ");
            int i=0;
            for(String car : splitted)
            {
                perso.setCaracteristique(i, Double.parseDouble(car));
                i++;
            }
            perso.setPiece(piece);
            lect.close();
            return perso;
        }
        catch (NullPointerException a)
        {
            System.out.println("Erreur : pointeur null" );
            perso=new Personnage("erreur");
            return perso;
        }
        catch (IOException a)
        {
            System.out.println("Problème d'IO" );
            perso=new Personnage("erreur");
            return perso;
        }
    }
    private static Personnage choixType(int type, String nom)
    {
        Personnage perso;
        if(type==0)
        {
            perso= new Chien(nom);
        }
        else if(type==1)
        {
            perso= new Chat(nom);
        }
        else if(type==2)
        {
            perso= new Lapin(nom);
        }
        else
        {
            perso= new Robot(nom);
        }
        return perso;
    }
}
