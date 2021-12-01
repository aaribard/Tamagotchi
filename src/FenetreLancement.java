import javax.swing.*;
import java.awt.Color;
import java.awt.Font;


public class FenetreLancement extends JFrame{
    JPanel panneau1;
    JPanel panneau2;
    JPanel panneau3;
    JPanel panneau4;
    JLabel texteQuestion; 
    JTextField champNom;
    JButton boutonQuitter;
    JButton boutonCharger;
    JButton boutonNouvellePartie;
    boolean active;


    FenetreLancement()
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

        texteQuestion =new JLabel("Voulez vous charger un partie existante ou commencer une nouvelle?"); 
        texteQuestion.setBounds(0,0,400,50);
        texteQuestion.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));

        panneau1.add(texteQuestion);


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
}
