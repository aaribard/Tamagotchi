import javax.swing.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Font;
import java.awt.event.*;

public class FenetreJeu extends JFrame{

    int largeur;
    int hauteur;
    boolean active;

    JPanel panneau1;
    JPanel panneau2;
    JPanel panneau3;
    JPanel panneau4;

    ImageIcon imagePiece;
    JLabel imagePieceLabel;

    ImageIcon imagePerso;
    JLabel imagePersoLabel;

    JLabel textNom;
    JLabel textAgeAns;
    JLabel textAgeMois;
    JLabel textAgeJours;
    JLabel textEtatPhys;
    JLabel textEtatMoral;

    JButton boutonSauvegarder;
    JButton boutonQuitter;

    JPanel barre1fond;
    JPanel barre2fond;
    JPanel barre3fond;
    JPanel barre4fond;
    JPanel barre5fond;
    JPanel barre6fond;

    JPanel barre1;
    JPanel barre2;
    JPanel barre3;
    JPanel barre4;
    JPanel barre5;
    JPanel barre6;


    JLabel titreBarre1;
    JLabel titreBarre2;
    JLabel titreBarre3;
    JLabel titreBarre4;
    JLabel titreBarre5;
    JLabel titreBarre6;

    JLabel image1Label;
    JLabel image2Label;
    JLabel image3Label;
    JLabel image4Label;
    JLabel image5Label;
    JLabel image6Label;

    JButton boutonManger;
    JButton boutonDormir;
    JButton boutonReveiller;
    JButton boutonAllerToilettes;
    JButton boutonLaver;
    JButton boutonJouer;

    JLabel imagePlanLabel;

    JLabel boutonSalon;
    JLabel boutonCuisine;
    JLabel boutonChambre;
    JLabel boutonSdb;
    JLabel boutonToilettes;
    JLabel boutonJardin;

    boolean demanderSauvegarder=false;
    boolean demanderQuitter=false;
    ArrayList<Boolean> boutonAppuye;

    FenetreJeu(Personnage perso, ArrayList<Piece> pieces)
    {
        largeur=800;
        hauteur=600;
        this.setTitle("Tamagotchi");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        boutonAppuye=new ArrayList<Boolean>(Arrays.asList(false,false,false,false,false,false));

        Color couleurFond= new Color(242,234,111);

        panneau1 = new JPanel();
        panneau1.setBounds(0,0,largeur*5/8,hauteur*1/2);
        panneau1.setBackground(couleurFond);
        panneau1.setLayout(null);
        panneau2 = new JPanel();
        panneau2.setBounds(largeur*5/8,0,largeur*3/8,hauteur*1/2);
        panneau2.setBackground(couleurFond);
        panneau2.setLayout(null);
        panneau3 = new JPanel();
        panneau3.setBounds(0,hauteur*1/2,largeur*5/8,hauteur*1/2);
        panneau3.setBackground(couleurFond);
        panneau3.setLayout(null);
        panneau4 = new JPanel();
        panneau4.setBounds(largeur*5/8,hauteur*1/2,largeur*3/8,hauteur*1/2);
        panneau4.setBackground(couleurFond);
        panneau4.setLayout(null);

        affichagePanneau1(perso);

        affichagePanneau2(perso);

        affichagePanneau3(perso);

        affichagePanneau4(perso, pieces);

        boutonPieceSetVisible(perso, pieces);
        boutonActionSetVisible(perso);

        this.add(panneau1);
        this.add(panneau2);
        this.add(panneau3);
        this.add(panneau4);

        this.setSize(largeur+16,hauteur+38);//taille de la barre de titre = 38px
        this.setLayout(null);
        this.setVisible(true);
    }
    
    void selectImagePerso(Personnage perso)
    {
        if (perso.getactiveButton(1))//animal endormi ou robot en charge
        {
            imagePerso=new ImageIcon(perso.getFichiersPersonnages(1));
        }
        else
        {
            imagePerso=new ImageIcon(perso.getFichiersPersonnages(0));
        }
    }

    void selectImagePiece(Personnage perso)
    {
        if(perso.getPiece()==0)
        {
            imagePiece=new ImageIcon(perso.getFichiersPieces(0));
        }
        if(perso.getPiece()==1)
        {
            imagePiece=new ImageIcon(perso.getFichiersPieces(1));
        }
        if(perso.getPiece()==2)
        {
            imagePiece=new ImageIcon(perso.getFichiersPieces(2));
        }
        if(perso.getPiece()==3)
        {
            imagePiece=new ImageIcon(perso.getFichiersPieces(3));
        }
        if(perso.getPiece()==4)
        {
            imagePiece=new ImageIcon(perso.getFichiersPieces(4));
        }
        if(perso.getPiece()==5)
        {
            imagePiece=new ImageIcon(perso.getFichiersPieces(5));
        }
    }

    public void affichagePanneau1(Personnage perso)
    {
        selectImagePerso(perso);

        imagePersoLabel=new JLabel(imagePerso);
        imagePersoLabel.setBounds(100,100,200,200);
        panneau1.add(imagePersoLabel);

        selectImagePiece(perso);

        imagePieceLabel=new JLabel(imagePiece);
        imagePieceLabel.setBounds(0,0,largeur*5/8,hauteur*1/2);
        panneau1.add(imagePieceLabel);
    }

    void affichagePanneau2(Personnage perso)
    {
        int l=largeur*3/8;
        int h=hauteur*1/2;
        textNom =new JLabel(perso.getNom());
        textNom.setFont(new Font("Bookman Old Style", Font.PLAIN, 24));
        textNom.setBounds((int)(l*0.08),(int)(h*0.1),100,30);
        panneau2.add(textNom);

        ArrayList<Integer> ageList = perso.getAge();

        textAgeAns =new JLabel(ageList.get(0)+" ans");
        textAgeAns.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        textAgeAns.setBounds((int)(l*0.2),(int)(h*0.25),100,20);
        panneau2.add(textAgeAns);

        textAgeMois =new JLabel(ageList.get(1)+" mois");
        textAgeMois.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        textAgeMois.setBounds((int)(l*0.2),(int)(h*0.25+20),100,20);
        panneau2.add(textAgeMois);

        textAgeJours =new JLabel(ageList.get(2)+" jours");
        textAgeJours.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        textAgeJours.setBounds((int)(l*0.2),(int)(h*0.25+40),100,20);
        panneau2.add(textAgeJours);

        textEtatPhys =new JLabel("Etat physique : "+perso.getEtatPhys());
        textEtatPhys.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        textEtatPhys.setBounds((int)(l*0.2),(int)(h*0.6),200,20);
        panneau2.add(textEtatPhys);

        textEtatMoral =new JLabel("Etat moral : "+perso.getEtatMoral());
        textEtatMoral.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
        textEtatMoral.setBounds((int)(l*0.2),(int)(h*0.6+20),200,20);
        panneau2.add(textEtatMoral);

        boutonSauvegarder=new JButton("Sauvegarder");
        boutonSauvegarder.setBounds((int)(l*0.1),(int)(h*0.85), 120, 24);
        panneau2.add(boutonSauvegarder);

        boutonSauvegarder.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
            {
                demanderSauvegarder=true;
            }});

        boutonQuitter=new JButton("Quitter");
        boutonQuitter.setBounds((int)(l*0.1+140), (int)(h*0.85), 120, 24);
        panneau2.add(boutonQuitter);

        boutonQuitter.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
            {
                fermerFenetre();
            }});
    }

    void affichagePanneau3(Personnage perso)
    {
        int l=largeur*5/8;
        int h=hauteur*1/2;

/*     -----     Affichage des fonds des barres des caracteristiques     -----     */

        barre1fond = new JPanel();
        barre1fond.setBounds((int)(l*0.3), (int)(h*0.05), (int)(l*0.5), (int)(h*0.08));
        barre1fond.setBackground(Color.black);
        barre1fond.setLayout(null);
        panneau3.add(barre1fond);

        barre2fond = new JPanel();
        barre2fond.setBounds((int)(l*0.3), (int)(h*0.2), (int)(l*0.5), (int)(h*0.08));
        barre2fond.setBackground(Color.black);
        barre2fond.setLayout(null);
        panneau3.add(barre2fond);

        barre3fond = new JPanel();
        barre3fond.setBounds((int)(l*0.3), (int)(h*0.35), (int)(l*0.5), (int)(h*0.08));
        barre3fond.setBackground(Color.black);
        barre3fond.setLayout(null);
        panneau3.add(barre3fond);

        barre4fond = new JPanel();
        barre4fond.setBounds((int)(l*0.3), (int)(h*0.50), (int)(l*0.5), (int)(h*0.08));
        barre4fond.setBackground(Color.black);
        barre4fond.setLayout(null);
        panneau3.add(barre4fond);

        barre5fond = new JPanel();
        barre5fond.setBounds((int)(l*0.3), (int)(h*0.65), (int)(l*0.5), (int)(h*0.08));
        barre5fond.setBackground(Color.black);
        barre5fond.setLayout(null);
        panneau3.add(barre5fond);

        barre6fond = new JPanel();
        barre6fond.setBounds((int)(l*0.3), (int)(h*0.80), (int)(l*0.5), (int)(h*0.08));
        barre6fond.setBackground(Color.black);
        barre6fond.setLayout(null);
        panneau3.add(barre6fond);

/*     -----     Affichage des barres des caracteristiques     -----     */

        barre1 = new JPanel();
        barre1.setBounds(4, 4, (int)((l*0.5-8)*(perso.getCaracteristique(0)/100)), (int)(h*0.08-8));
        barre1.setBackground(getCouleurBarre((int)perso.getCaracteristique(0)));
        barre1fond.add(barre1);

        barre2 = new JPanel();
        barre2.setBounds(4, 4, (int)((l*0.5-8)*(perso.getCaracteristique(1)/100)), (int)(h*0.08-8));
        barre2.setBackground(getCouleurBarre((int)perso.getCaracteristique(1)));
        barre2fond.add(barre2);

        barre3 = new JPanel();
        barre3.setBounds(4, 4, (int)((l*0.5-8)*(perso.getCaracteristique(2)/100)), (int)(h*0.08-8));
        barre3.setBackground(getCouleurBarre((int)perso.getCaracteristique(2)));
        barre3fond.add(barre3);

        barre4 = new JPanel();
        barre4.setBounds(4, 4, (int)((l*0.5-8)*(perso.getCaracteristique(3)/100)), (int)(h*0.08-8));
        barre4.setBackground(getCouleurBarre((int)perso.getCaracteristique(3)));
        barre4fond.add(barre4);

        barre5 = new JPanel();
        barre5.setBounds(4, 4, (int)((l*0.5-8)*(perso.getCaracteristique(4)/100)), (int)(h*0.08-8));
        barre5.setBackground(getCouleurBarre((int)perso.getCaracteristique(4)));
        barre5fond.add(barre5);

        barre6 = new JPanel();
        barre6.setBounds(4, 4, (int)((l*0.5-8)*(perso.getCaracteristique(5)/100)), (int)(h*0.08-8));
        barre6.setBackground(getCouleurBarre((int)perso.getCaracteristique(5)));
        barre6fond.add(barre6);
        
/*     -----     Affichage des titres des barres des caracteristiques     -----     */

        titreBarre1= new JLabel(perso.getNomCaracteristiques().get(0));
        titreBarre1.setBounds((int)(l*0.05), (int)(h*0.05), (int)(l*0.2), (int)(h*0.08));
        titreBarre1.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        panneau3.add(titreBarre1);

        titreBarre2= new JLabel(perso.getNomCaracteristiques().get(1));
        titreBarre2.setBounds((int)(l*0.05), (int)(h*0.2), (int)(l*0.2), (int)(h*0.08));
        titreBarre2.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        panneau3.add(titreBarre2);

        titreBarre3= new JLabel(perso.getNomCaracteristiques().get(2));
        titreBarre3.setBounds((int)(l*0.05), (int)(h*0.35), (int)(l*0.2), (int)(h*0.08));
        titreBarre3.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        panneau3.add(titreBarre3);

        titreBarre4= new JLabel(perso.getNomCaracteristiques().get(3));
        titreBarre4.setBounds((int)(l*0.05), (int)(h*0.5), (int)(l*0.2), (int)(h*0.08));
        titreBarre4.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        panneau3.add(titreBarre4);

        titreBarre5= new JLabel(perso.getNomCaracteristiques().get(4));
        titreBarre5.setBounds((int)(l*0.05), (int)(h*0.65), (int)(l*0.2), (int)(h*0.08));
        titreBarre5.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        panneau3.add(titreBarre5);

        titreBarre6= new JLabel(perso.getNomCaracteristiques().get(5));
        titreBarre6.setBounds((int)(l*0.05), (int)(h*0.8), (int)(l*0.2), (int)(h*0.08));
        titreBarre6.setFont(new Font("Bookman Old Style", Font.PLAIN, 14));
        panneau3.add(titreBarre6);

/*     -----     Affichage des icones barres des caracteristiques     -----     */

        image1Label=new JLabel(new ImageIcon(perso.getFichiersCaracteristique(0)));
        image1Label.setBounds((int)(l*0.3-24),(int)(h*0.05),24,24);
        panneau3.add(image1Label);

        image2Label=new JLabel(new ImageIcon(perso.getFichiersCaracteristique(1)));
        image2Label.setBounds((int)(l*0.3-24),(int)(h*0.2),24,24);
        panneau3.add(image2Label);

        image3Label=new JLabel(new ImageIcon(perso.getFichiersCaracteristique(2)));
        image3Label.setBounds((int)(l*0.3-24),(int)(h*0.35),24,24);
        panneau3.add(image3Label);

        image4Label=new JLabel(new ImageIcon(perso.getFichiersCaracteristique(3)));
        image4Label.setBounds((int)(l*0.3-24),(int)(h*0.5),24,24);
        panneau3.add(image4Label);

        image5Label=new JLabel(new ImageIcon(perso.getFichiersCaracteristique(4)));
        image5Label.setBounds((int)(l*0.3-24),(int)(h*0.65),24,24);
        panneau3.add(image5Label);

        image6Label=new JLabel(new ImageIcon(perso.getFichiersCaracteristique(5)));
        image6Label.setBounds((int)(l*0.3-24),(int)(h*0.8),24,24);
        panneau3.add(image6Label);

        boutonManger=new JButton(perso.getNomActions(0));
        boutonManger.setBounds((int)(l*0.3+l*0.5), (int)(h*0.2), 100, 24);
        panneau3.add(boutonManger);

        boutonManger.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
            {
                boutonAppuye.set(0,true);
            }});

        boutonDormir=new JButton(perso.getNomActions(1));
        boutonDormir.setBounds((int)(l*0.3+l*0.5), (int)(h*0.35), 100, 24);
        panneau3.add(boutonDormir);

        boutonDormir.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
            {
                boutonDormir.setVisible(false);
                boutonReveiller.setVisible(true);
                boutonAppuye.set(1,true);
            }});

        boutonReveiller=new JButton(perso.getNomActions(2));
        boutonReveiller.setBounds((int)(l*0.3+l*0.5), (int)(h*0.35), 100, 24);
        boutonReveiller.setVisible(false);
        panneau3.add(boutonReveiller);

        boutonReveiller.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
            {
                boutonDormir.setVisible(true);
                boutonReveiller.setVisible(false);
                boutonAppuye.set(2,true);
            }});

        boutonLaver=new JButton(perso.getNomActions(3));
        boutonLaver.setBounds((int)(l*0.3+l*0.5), (int)(h*0.5), 100, 24);
        panneau3.add(boutonLaver);

        boutonLaver.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
            {
                boutonAppuye.set(3,true);
            }});

        boutonAllerToilettes=new JButton(perso.getNomActions(4));
        boutonAllerToilettes.setBounds((int)(l*0.3+l*0.5), (int)(h*0.65), 100, 24);
        panneau3.add(boutonAllerToilettes);

        boutonAllerToilettes.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
            {
                boutonAppuye.set(4,true);
            }});

        boutonJouer=new JButton(perso.getNomActions(5));
        boutonJouer.setBounds((int)(l*0.3+l*0.5), (int)(h*0.8), 100, 24);
        panneau3.add(boutonJouer);

        boutonJouer.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e)
            {
                boutonAppuye.set(5,true);
            }});
    }

    private void affichagePanneau4(Personnage perso, ArrayList<Piece> pieces)
    {
        boutonSalon=new JLabel(new ImageIcon("img/Plan/fleche.png"));
        boutonSalon.setBounds(90, 180, 24, 24);
        panneau4.add(boutonSalon);

        boutonSalon.addMouseListener(new MouseAdapter(){public void mouseClicked(MouseEvent e)
            {
                perso.setPiece(0);
                boutonPieceSetVisible(perso, pieces);
                boutonActionSetVisible(perso);
            }});

        boutonCuisine=new JLabel(new ImageIcon("img/Plan/fleche.png"));
        boutonCuisine.setBounds(20, 220, 24, 24);
        panneau4.add(boutonCuisine);

        boutonCuisine.addMouseListener(new MouseAdapter(){public void mouseClicked(MouseEvent e)
            {
                perso.setPiece(1);
                boutonPieceSetVisible(perso, pieces);
                boutonActionSetVisible(perso);
            }});

        boutonChambre=new JLabel(new ImageIcon("img/Plan/fleche.png"));
        boutonChambre.setBounds(160, 200, 24, 24);
        panneau4.add(boutonChambre);

        boutonChambre.addMouseListener(new MouseAdapter(){public void mouseClicked(MouseEvent e)
            {
                perso.setPiece(2);
                boutonPieceSetVisible(perso, pieces);
                boutonActionSetVisible(perso);
            }});

        boutonSdb=new JLabel(new ImageIcon("img/Plan/fleche.png"));
        boutonSdb.setBounds(160, 150, 24, 24);
        panneau4.add(boutonSdb);

        boutonSdb.addMouseListener(new MouseAdapter(){public void mouseClicked(MouseEvent e)
            {
                perso.setPiece(3);
                boutonPieceSetVisible(perso, pieces);
                boutonActionSetVisible(perso);
            }});

        boutonToilettes=new JLabel(new ImageIcon("img/Plan/fleche.png"));
        boutonToilettes.setBounds(160, 105, 24, 24);
        panneau4.add(boutonToilettes);

        boutonToilettes.addMouseListener(new MouseAdapter(){public void mouseClicked(MouseEvent e)
            {
                perso.setPiece(4);
                boutonPieceSetVisible(perso, pieces);
                boutonActionSetVisible(perso);
            }});

        boutonJardin=new JLabel(new ImageIcon("img/Plan/fleche.png"));
        boutonJardin.setBounds(90, 65, 24, 24);
        panneau4.add(boutonJardin);

        boutonJardin.addMouseListener(new MouseAdapter(){public void mouseClicked(MouseEvent e)
            {
                perso.setPiece(5);
                boutonPieceSetVisible(perso, pieces);
                boutonActionSetVisible(perso);
            }});

        imagePlanLabel=new JLabel(new ImageIcon("img/Plan/PlanMaison.png"));
        imagePlanLabel.setBounds(0,0,300,300);
        panneau4.add(imagePlanLabel);
    }

    void boutonPieceSetVisible(Personnage perso, ArrayList<Piece> pieces)
    {
        JLabel[] boutonPieceListe = {boutonSalon, boutonCuisine, boutonChambre, boutonSdb, boutonToilettes, boutonJardin};
        for(int i=0;i<boutonPieceListe.length;i++)
        {
            if(i==perso.getPiece())
            {
                boutonPieceListe[i].setVisible(false);
            }
            else
            {
                if(pieces.get(perso.getPiece()).getPieceAdja().contains(pieces.get(i)))
                {
                    boutonPieceListe[i].setVisible(true);
                }
                else
                {
                    boutonPieceListe[i].setVisible(false);
                }
            }
        }
    }

    void boutonActionSetVisible(Personnage perso)
    {
        boutonActionReset();
        if(perso.getPiece()==0)
        {
        }
        else if(perso.getPiece()==1)
        {
            boutonManger.setVisible(true);
        }
        else if(perso.getPiece()==2)
        {
            boutonDormir.setVisible(true);
        }
        else if(perso.getPiece()==3)
        {
            boutonLaver.setVisible(true);
        }
        else if(perso.getPiece()==4)
        {
            boutonAllerToilettes.setVisible(true);
        }
        else if(perso.getPiece()==5)
        {
            boutonJouer.setVisible(true);
        }
    }

    void boutonActionReset()
    {
        boutonManger.setVisible(false);
        boutonDormir.setVisible(false);
        boutonReveiller.setVisible(false);
        boutonLaver.setVisible(false);
        boutonAllerToilettes.setVisible(false);
        boutonJouer.setVisible(false);
    }

    ArrayList<Boolean> getBoutonAppuye()
    {
        return boutonAppuye;
    }
    void resetBoutonAppuye()
    {
        boutonAppuye=new ArrayList<Boolean>(Arrays.asList(false,false,false,false,false,false));
    }

    boolean getBoutonSauvegarde()
    {
        return demanderSauvegarder;
    }
    void resetBoutonSauvegarde()
    {
        demanderSauvegarder=false;
    }
    boolean getBoutonQuitter()
    {
        return demanderQuitter;
    }
    void resetBoutonQuitter()
    {
        demanderQuitter=false;
    }

    private Color getCouleurBarre(int val)
    {
        if (val!=0)
        {
            return new Color(255-255*val/100,255*val/100,0);
        }
        else
        {
            return new Color(255,0,0);
        }
    }

    void fermerFenetre()
    {
        demanderQuitter=true;
        this.dispose();
    }

    boolean getActive()
    {
        return active;
    }


    void refresh(Personnage perso)
    {
        selectImagePerso(perso);
        imagePersoLabel.setIcon(imagePerso);
        selectImagePiece(perso);
        imagePieceLabel.setIcon(imagePiece);

        textEtatPhys.setText("Etat physique : "+perso.getEtatPhys());

        textEtatMoral.setText("Etat moral : "+perso.getEtatMoral());

        int l=largeur*5/8;
        int h=hauteur*1/2;

        barre1.setBounds(4, 4, (int)((l*0.5-8)*(perso.getCaracteristique(0)/100)), (int)(h*0.08-8));
        barre1.setBackground(getCouleurBarre((int)perso.getCaracteristique(0)));

        barre2.setBounds(4, 4, (int)((l*0.5-8)*(perso.getCaracteristique(1)/100)), (int)(h*0.08-8));
        barre2.setBackground(getCouleurBarre((int)perso.getCaracteristique(1)));

        barre3.setBounds(4, 4, (int)((l*0.5-8)*(perso.getCaracteristique(2)/100)), (int)(h*0.08-8));
        barre3.setBackground(getCouleurBarre((int)perso.getCaracteristique(2)));

        barre4.setBounds(4, 4, (int)((l*0.5-8)*(perso.getCaracteristique(3)/100)), (int)(h*0.08-8));
        barre4.setBackground(getCouleurBarre((int)perso.getCaracteristique(3)));

        barre5.setBounds(4, 4, (int)((l*0.5-8)*(perso.getCaracteristique(4)/100)), (int)(h*0.08-8));
        barre5.setBackground(getCouleurBarre((int)perso.getCaracteristique(4)));

        barre6.setBounds(4, 4, (int)((l*0.5-8)*(perso.getCaracteristique(5)/100)), (int)(h*0.08-8));
        barre6.setBackground(getCouleurBarre((int)perso.getCaracteristique(5)));
    }
}
