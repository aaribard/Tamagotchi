import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;


public class FenetreLancement extends JFrame{
    JPanel panneau1;
    JPanel panneau2;
    JPanel panneau3;
    JPanel panneau4;
    JLabel texteQuestion; 
    JTextField champNom;

    JButton boutonNouvellePartie;

    JButton boutonChargerPartie1;
    JButton boutonChargerPartie2;
    JButton boutonChargerPartie3;
    JButton boutonChargerPartie4;

    JButton flecheChargerPartieDroite;
    JButton flecheChargerPartieGauche;

    int fileOffset=0;

    JLabel texteChargerPartie;
    JButton boutonQuitter;
    boolean active;
    int fermeture=0; // 1=Bouton quitter // 2=Nouvelle partie // 3=Charger partie

    String fileToStart;


    FenetreLancement()
    {

        Color couleurFond= new Color(242,234,111);
        this.setTitle("Création Tamagotchi");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        active = true;

        panneau1 = new JPanel();
        panneau1.setBounds(0,0,400,50);
        panneau1.setBackground(couleurFond);
        panneau2 = new JPanel();
        panneau2.setBounds(0,50,400,50);
        panneau2.setBackground(couleurFond);
        panneau2.setLayout(null);
        panneau3 = new JPanel();
        panneau3.setBounds(0,100,400,150);
        panneau3.setBackground(couleurFond);
        panneau3.setLayout(null);
        panneau4 = new JPanel();
        panneau4.setBounds(0,250,400,50);
        panneau4.setBackground(couleurFond);
        panneau4.setLayout(null);

        //     -----     panneau 1     -----     
        
        texteQuestion =new JLabel("<html>Voulez vous charger un partie existante <br/>ou commencer une nouvelle?</html>"); 
        texteQuestion.setBounds(0,0,400,50);
        texteQuestion.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        panneau1.add(texteQuestion);

        //     -----     panneau 2     -----     

        boutonNouvellePartie = new JButton("Nouvelle partie");
        boutonNouvellePartie.setBounds(0,0,400,50);
        boutonNouvellePartie.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        boutonNouvellePartie.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
            {   
                fermeture=2;
                active=false;
                fermerFenetre();
            }});
        panneau2.add(boutonNouvellePartie);

        //     -----     panneau 3     -----     

        texteChargerPartie = new JLabel("Charger partie", JLabel.CENTER);
        texteChargerPartie.setBounds(0,0,400,50);
        texteChargerPartie.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));

        panneau3.add(texteChargerPartie);

        ArrayList<String[]> e = getListeSauvegardes();

        if(e.size()>=1)
        {
        boutonChargerPartie1 = new JButton("<html>"+e.get(0)[0]+"<br/>"+e.get(0)[1]+"/"+e.get(0)[2]+"/"+e.get(0)[3]+"</html>");
        boutonChargerPartie1.setBounds(20,50,180,50);
        boutonChargerPartie1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        boutonChargerPartie1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
            {
                fermeture=3;
                setFileToStart(1);
            }});
        panneau3.add(boutonChargerPartie1);
        }
        if(e.size()>=2)
        {
            boutonChargerPartie2 = new JButton("<html>"+e.get(1)[0]+"<br/>"+e.get(1)[1]+"/"+e.get(1)[2]+"/"+e.get(1)[3]+"</html>");
            boutonChargerPartie2.setBounds(200,50,180,50);
            boutonChargerPartie2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
            boutonChargerPartie2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
                {
                    fermeture=3;
                    setFileToStart(2);
                }});
            panneau3.add(boutonChargerPartie2);
        }
        if(e.size()>=3)
        {
            boutonChargerPartie3 = new JButton("<html>"+e.get(2)[0]+"<br/>"+e.get(2)[1]+"/"+e.get(2)[2]+"/"+e.get(2)[3]+"</html>");
            boutonChargerPartie3.setBounds(20,100,180,50);
            boutonChargerPartie3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
            boutonChargerPartie3.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
                {
                    fermeture=3;
                    setFileToStart(3);
                }});
            panneau3.add(boutonChargerPartie3);
        }
        if(e.size()>=4)
        {
            boutonChargerPartie4 = new JButton("<html>"+e.get(3)[0]+"<br/>"+e.get(3)[1]+"/"+e.get(3)[2]+"/"+e.get(3)[3]+"</html>");
            boutonChargerPartie4.setBounds(200,100,180,50);
            boutonChargerPartie4.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
            boutonChargerPartie4.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
                {
                    fermeture=3;
                    setFileToStart(4);
                }});
            panneau3.add(boutonChargerPartie4);
        }
        if(e.size()>4)//si il y a plus de 4 fichiers, les fleches sont ajoutées
        {
            flecheChargerPartieDroite = new JButton();
            flecheChargerPartieDroite.setBounds(380,50,20,100);
            flecheChargerPartieDroite.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
                {
                    fileOffset+=4;//decalage de 4 fichiers vers la droite 
                    refreshBoutonCharger();
                }});

            flecheChargerPartieGauche = new JButton();
            flecheChargerPartieGauche.setBounds(0,50,20,100);
            flecheChargerPartieGauche.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
                {
                    if(fileOffset>0)
                    {
                        fileOffset-=4;//decalage de 4 fichiers vers la gauche 
                    }
                    refreshBoutonCharger();
                }});

            panneau3.add(flecheChargerPartieDroite);
            panneau3.add(flecheChargerPartieGauche);
        }

        //     -----     panneau 4     -----     

        boutonQuitter = new JButton("Quitter");
        boutonQuitter.setBounds(300,0,100,50);
        boutonQuitter.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        boutonQuitter.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
            {
                fermeture=1;
                active=false;
                fermerFenetre();
            }});
        panneau4.add(boutonQuitter);


        this.add(panneau1);
        this.add(panneau2);
        this.add(panneau3);
        this.add(panneau4);
        this.setSize(400+16,300+38);//300+38 taille de la barre de titre = 38px
        this.setLayout(null);
        this.setVisible(true);

    }
    void fermerFenetre()
    {
        this.dispose();
    }
    boolean getActive()
    {
        return active;
    }
    int getFermeture()//recupere la raison de la fermeture
    {
        return fermeture;
    }

    void setFileToStart(int id)//choisi le fichier a lancer en fonction du bouton appuyé
    {
        File repertoire = new File("save");
        String liste[] = repertoire.list();      
        fileToStart=liste[id+fileOffset-1];
        active=false;
        fermerFenetre();
    }

    String getFileToStart()
    {
        return fileToStart;
    }

    ArrayList<String[]> getListeSauvegardes() //recupere les fichiers .txt dans le dossier save
    {
        ArrayList<String[]> listeSauvegardes=new ArrayList<String[]>();
        File repertoire = new File("save");
        String liste[] = repertoire.list();      
 
        if (liste != null) 
        {         
            for (int i = fileOffset; i < liste.length; i++) 
            {
                String[] splitDot = liste[i].split("\\.");//decouper au point pour enlever ".txt"
                String[] elemNom = splitDot[0].split("_");//decouper aux "_"
                listeSauvegardes.add(elemNom);
            }
        }
        else 
        {
            System.err.println("Nom de repertoire invalide");
        }
        return listeSauvegardes;
    }

    void refreshBoutonCharger()
    {
        ArrayList<String[]> e = getListeSauvegardes();
        boutonChargerPartie1.setVisible(false);
        boutonChargerPartie2.setVisible(false);
        boutonChargerPartie3.setVisible(false);
        boutonChargerPartie4.setVisible(false);

        if(e.size()>=1)//si il y a seulement 1 fichier
        {
            boutonChargerPartie1.setText("<html>"+e.get(0)[0]+"<br/>"+e.get(0)[1]+"/"+e.get(0)[2]+"/"+e.get(0)[3]+"</html>");
            boutonChargerPartie1.setVisible(true);
        }
        if(e.size()>=2)//si il y a seulement 2 fichier
        {
            boutonChargerPartie2.setText("<html>"+e.get(1)[0]+"<br/>"+e.get(1)[1]+"/"+e.get(1)[2]+"/"+e.get(1)[3]+"</html>");
            boutonChargerPartie2.setVisible(true);
        }
        if(e.size()>=3)//etc
        {
            boutonChargerPartie3.setText("<html>"+e.get(2)[0]+"<br/>"+e.get(2)[1]+"/"+e.get(2)[2]+"/"+e.get(2)[3]+"</html>");
            boutonChargerPartie3.setVisible(true);
        }
        if(e.size()>=4)
        {
            boutonChargerPartie4.setText("<html>"+e.get(3)[0]+"<br/>"+e.get(3)[1]+"/"+e.get(3)[2]+"/"+e.get(3)[3]+"</html>");
            boutonChargerPartie4.setVisible(true);
        }
        panneau3.repaint();
    }




    
}
