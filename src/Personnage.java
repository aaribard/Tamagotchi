import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.lang.model.util.ElementScanner6;


public class Personnage {
	private String nom;
	private LocalDate dateNaissance;
	private int pieceActuelle;
	private ArrayList<Double> caracteristiques;
	protected ArrayList<String> nomCaracteristiques;
	private String etatPhysique;
	private String etatMoral;
	protected int type=1;

	private ArrayList<Boolean> activeButton;
	private ArrayList<Instant> activeButtonTime;

	protected ArrayList<Duration> activeButtonMaxTime;
	protected ArrayList<ArrayList<Double>> activeButtonSpeed;

	protected ArrayList<Double> CaractTimeSpeed;

	protected ArrayList<String> fichiersCaracteristiques;
	protected ArrayList<String> fichiersPieces;
	protected ArrayList<String> fichiersPersonnages;

	protected ArrayList<String> nomActions;

	
	public Personnage(String n)
	{
		nom=n;
		dateNaissance=LocalDate.now();
		pieceActuelle=0;
		etatPhysique="En forme";
		etatMoral="Heureux";
		caracteristiques=new ArrayList<Double>();
		caracteristiques.add(100.);
		caracteristiques.add(70.);
		caracteristiques.add(70.);
		caracteristiques.add(70.);
		caracteristiques.add(70.);
		caracteristiques.add(70.);
		activeButton = new ArrayList<Boolean>(Arrays.asList(false,false,false,false,false,false));
		activeButtonTime = new ArrayList<Instant>(Arrays.asList(Instant.now(),Instant.now(),Instant.now(),Instant.now(),Instant.now(),Instant.now()));
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
		if(v<=0.)
		{
			caracteristiques.set(n,0.);
		}
		else if(v>100)
		{
			caracteristiques.set(n,100.);
		}
		else
		{
			caracteristiques.set(n,v);
		}
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

	public String getFichiersCaracteristique(int i)
	{
		return fichiersCaracteristiques.get(i);
	}
	public String getFichiersPieces(int i)
	{
		return fichiersPieces.get(i);
	}
	public String getFichiersPersonnages(int i)
	{
		return fichiersPersonnages.get(i);
	}
	public String getNomActions(int i)
	{
		return nomActions.get(i);
	}

	public boolean getactiveButton(int n)
	{
		return activeButton.get(n);
	}
	public void setActiveButton(int n, boolean v)
	{
		activeButton.set(n,v);
	}
	public Instant getactiveButtonTime(int n)
	{
		return activeButtonTime.get(n);
	}
	public void setActiveButtonTime(int n, Instant v)
	{
		activeButtonTime.set(n,v);
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
	public void setAllCaracteristiques(ArrayList<Boolean> b)
	{
		//bouton actifs
		if(b.get(0)==true)//manger
		{			
			setActiveButton(0, true);
			setActiveButtonTime(0, Instant.now());
		}
		if(b.get(1)==true)//dormir
		{
			setActiveButton(1, true);
			setActiveButton(2, false);
			setActiveButtonTime(1, Instant.now());
		}
		if(b.get(2)==true)//reveiller
		{
			setActiveButton(2, true);
			setActiveButton(1, false);
			setActiveButtonTime(2, Instant.now());
		}
		if(b.get(3)==true)//laver
		{
			setActiveButton(3, true);
			setActiveButtonTime(3, Instant.now());
		}
		if(b.get(4)==true)//toilettes
		{
			setActiveButton(4, true);
			setActiveButtonTime(4, Instant.now());
		}
		if(b.get(5)==true)//jouer
		{
			setActiveButton(5, true);
			setActiveButtonTime(5, Instant.now());
		}

		//evolution caracteristiques avec le temps

		for(int i=0;i<6;i++)
		{
			this.setCaracteristique(i, this.getCaracteristique(i)+CaractTimeSpeed.get(i)*0.05);
		}

		//evolution caracteristiques avec les boutons
		for(int i=0;i<activeButton.size();i++)
		{
			if(activeButton.get(i))
			{
				if(Duration.between(activeButtonTime.get(i),Instant.now()).toSeconds()<activeButtonMaxTime.get(i).toSeconds())
				{
					for(int j=0;j<6;j++)
					{
						this.setCaracteristique(j, this.getCaracteristique(j)+activeButtonSpeed.get(i).get(j)*0.05);
					}
				}
				else
				{
					activeButton.set(i,false);
				}
			}
		}
		//evolution de la vie
		int nb=0;
		for(int i=1;i<6;i++)
		{
			if(this.getCaracteristique(i)>80)
			{
				nb+=1;
			}
			if(this.getCaracteristique(i)<20)
			{
				nb-=1;
			}
		}
		if(nb>=4)
		{
			this.setCaracteristique(0, this.getCaracteristique(0)+0.1);
		}
		else if(nb>=3)
		{
			this.setCaracteristique(0, this.getCaracteristique(0)+0.05);
		}

		else if(nb<=-4)
		{
			this.setCaracteristique(0, this.getCaracteristique(0)-0.1);
		}
		else if(nb<=-3)
		{
			this.setCaracteristique(0, this.getCaracteristique(0)-0.05);
		}
		//evolution de l'etat physique
		if(this.getCaracteristique(2)<30)
		{
			etatPhysique="Fatigué";
		}
		else if(this.getCaracteristique(2)<10)
		{
			etatPhysique="Exténué";
		}
		else if(this.getCaracteristique(2)>80)
		{
			etatPhysique="En pleine forme";
		}
		else
		{
			etatPhysique="En forme";
		}

	}



}
