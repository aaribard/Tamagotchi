import java.util.ArrayList;

public class Interface{
    private FenetreCreation f1;
    private FenetreJeu f2;
    private Personnage perso;
    private ArrayList<Piece> pieces;
    Interface(String i,Personnage p, ArrayList<Piece> pi)
    {
        perso =p;
        pieces = pi;
    }
    void initFenetreCreation()
    {
        f1=new FenetreCreation();
    }
    void initFenetreJeu()
    {
        f2=new FenetreJeu(perso,pieces);
    }
    String getNomCreation()
    {
        return f1.getNom();
    }
    Personnage getPersonnageCreation()
    {
        return f1.getPersonnage();
    }
    boolean getActiveCreation()
    {
        return f1.getActive();
    }
    boolean getActiveJeu()
    {
        return f2.getActive();
    }
    ArrayList<Boolean> getBoutonAppuye()
    {
        return f2.getBoutonAppuye();
    }

}

