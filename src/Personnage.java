import java.time.LocalDate;
import java.time.Period;

import java.util.ArrayList;

public class Personnage {
	private String nom;
	private LocalDate dateNaissance;
	private int pieceActuelle;
	private ArrayList<Double> caracteristiques;
	protected ArrayList<String> nomCaracteristiques;
	private String etatPhysique;
	private String etatMoral;
	protected int type=1;
	
	public Personnage(String n)
	{
		nom=n;
		dateNaissance=LocalDate.now();
		pieceActuelle=0;
		etatPhysique="En forme";
		etatMoral="Heureux";
		caracteristiques=new ArrayList<Double>();
		caracteristiques.add(10.);
		caracteristiques.add(25.);
		caracteristiques.add(45.);
		caracteristiques.add(65.);
		caracteristiques.add(85.);
		caracteristiques.add(100.);
	}
	
	public String getNom()
	{
		return nom;
	}
	public LocalDate getDateNaissance()
	{
		return dateNaissance;
	}
	public ArrayList<Integer> getDateNaissanceListe()
	{
		ArrayList<Integer> dateList = new ArrayList<Integer>();
		dateList.add(dateNaissance.getYear());
		dateList.add(dateNaissance.getMonthValue());
		dateList.add(dateNaissance.getDayOfMonth());
		return dateList;
	}
	public void setDateNaissance(int annee, int mois, int jour)
	{
		dateNaissance=LocalDate.of(annee, mois , jour);
	}
	public int getType()
	{
		return type;
	}
	public int getPiece()
	{
		return pieceActuelle;
	}
	public void setPiece(int p)
	{
		pieceActuelle=p;
	}
	public ArrayList<String> getNomCaracteristiques()
    {
        return nomCaracteristiques;
    }
	public void setCaracteristique(int n, double v)
	{
		caracteristiques.set(n,v);
	}
	public double getCaracteristique(int n)
	{
		return caracteristiques.get(n);
	}
	public ArrayList<Double> getCaracteristiqueList()
	{
		return caracteristiques;
	}
	public String getCaracteristiqueString()
	{
		String retour="";
		retour+=caracteristiques.get(0).toString();
		for(int i=1;i<caracteristiques.size();i++)
		{
			retour+=" ";
			retour+=caracteristiques.get(i).toString();
		}
		return retour;
	}
	public ArrayList<Integer> getAge()
	{
		LocalDate d=LocalDate.now();
		ArrayList<Integer> ageList = new ArrayList<Integer>();
		Period age = Period.between(dateNaissance, d);
		ageList.add(age.getYears());
		ageList.add(age.getMonths());
		ageList.add(age.getDays());

		return ageList;
	}
	public String getEtatPhys()
	{
		return etatPhysique;
	}
	public String getEtatMoral()
	{
		return etatMoral;
	}
	public void setEtatPhys(String s)
	{
		etatPhysique=s;
	}
	public void setEtatMoral(String s)
	{
		etatMoral=s;
	}
}
