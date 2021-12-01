import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class FenetreCreation extends JFrame{
    JPanel panneau1;
    JPanel panneau2;
    JPanel panneau3;
    JPanel panneau4;
    JLabel titre; 
    JTextField champNom;
    JButton boutonChien;
    JButton boutonChat;
    JButton boutonLapin;
    JButton boutonRobot;
    JButton boutonJouer;
    int typeSelection;
    String nom;
    Personnage perso;
    boolean active;


    FenetreCreation()
    {
        this.setTitle("Création Tamagotchi");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        active = true;
        panneau1 = new JPanel();
        panneau1.setBounds(0,0,400,50);
        panneau1.setBackground(Color.red);
        panneau2 = new JPanel();
        panneau2.setBounds(0,50,400,50);
        panneau2.setBackground(Color.blue);
        panneau2.setLayout(null);
        panneau3 = new JPanel();
        panneau3.setBounds(0,100,400,150);
        panneau3.setBackground(Color.green);
        panneau3.setLayout(null);
        panneau4 = new JPanel();
        panneau4.setBounds(0,250,400,50);
        panneau4.setBackground(Color.black);
        panneau4.setLayout(null);

        titre =new JLabel("Choisissez le nom et le type de votre personnage?"); 
        panneau1.add(titre);

        champNom = new JTextField("Nom");
        champNom.setBounds(0,0,400,50);


        panneau2.add(champNom);  

        boutonChien = new JButton("Chien");
        boutonChien.setBounds(0,0,200,75);
        boutonChat = new JButton("Chat");
        boutonChat.setBounds(200,0,200,75);
        boutonLapin = new JButton("Lapin");
        boutonLapin.setBounds(0,75,200,75);
        boutonRobot = new JButton("Robot");
        boutonRobot.setBounds(200,75,200,75);

        typeSelection=0;

        boutonChien.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
            {
                boutonChien.setBackground(Color.gray);
                boutonChat.setBackground(Color.white);
                boutonLapin.setBackground(Color.white);
                boutonRobot.setBackground(Color.white);
                typeSelection=0;
            }});
        boutonChat.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
            {
                boutonChien.setBackground(Color.white);
                boutonChat.setBackground(Color.gray);
                boutonLapin.setBackground(Color.white);
                boutonRobot.setBackground(Color.white);
                typeSelection=1;
            }});
        boutonLapin.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
            {
                boutonChien.setBackground(Color.white);
                boutonChat.setBackground(Color.white);
                boutonLapin.setBackground(Color.gray);
                boutonRobot.setBackground(Color.white);
                typeSelection=2;
            }});
        boutonRobot.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
            {
                boutonChien.setBackground(Color.white);
                boutonChat.setBackground(Color.white);
                boutonLapin.setBackground(Color.white);
                boutonRobot.setBackground(Color.gray);
                typeSelection=3;
            }});

        panneau3.add(boutonChien);
        panneau3.add(boutonChat);
        panneau3.add(boutonLapin);
        panneau3.add(boutonRobot);

        boutonJouer = new JButton("Jouer");
        boutonJouer.setBounds(100,0,200,50);

        boutonJouer.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
            {
                nom=champNom.getText();
                if(typeSelection==0)
                {
                    perso=new Chien(nom);
                }
                else if(typeSelection==1)
                {
                    perso=new Chat(nom);
                }
                else if(typeSelection==2)
                {
                    perso=new Lapin(nom);
                }
                else if(typeSelection==3)
                {
                    perso=new Robot(nom);
                }
                active = false;
                fermerFenetre();
            }});
        
        panneau4.add(boutonJouer);

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
    String getNom()
    {
        return nom;
    }
    Personnage getPersonnage()
    {
        return perso;
    }
    boolean getActive()
    {
        return active;
    }
}
