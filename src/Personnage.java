import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class Personnage {
	private String nom;
	private LocalDate dateNaissance;
	private int pieceActuelle;
	private ArrayList<Double> caracteristiques;
	private String etatPhysique;
	private String etatMoral;
	protected int type;

	private ArrayList<Boolean> activeButton;					//liste des actions activés
	private ArrayList<Instant> activeButtonTime;				//liste des moments d'activation des actions

	protected ArrayList<Duration> activeButtonMaxTime;			//liste des temps max d'activation des actions
	protected ArrayList<ArrayList<Double>> activeButtonSpeed;	//liste des vitesse d'influence des actions sur les caracteristiques

	protected ArrayList<Double> CaractTimeSpeed;				//liste des vitesse d'influence du temps sur les caracteristiques

	protected ArrayList<String> fichiersCaracteristiques;		//liste des noms de fichier des icones de barres
	protected ArrayList<String> fichiersPieces;					//liste des noms de fichier des images de fond des pieces
	protected ArrayList<String> fichiersPersonnages;			//liste des noms de fichier des images des personnages

	protected ArrayList<String> nomActions;						//liste des noms des actions
	protected ArrayList<String> nomCaracteristiques;			//liste des noms des caracteristiques
	
	public Personnage(String n)
	{
		nom=n;
		dateNaissance=LocalDate.now();
		pieceActuelle=0;
		etatPhysique="En forme";
		etatMoral="Heureux";
		caracteristiques=new ArrayList<Double>(Arrays.asList(100.,70.,70.,70.,70.,70.));	//valeurs par defaut des caracteristiques
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
	public void setCaracteristique(int n, double v) //Set la valeur de la caracteristique n, verifie si 0<=v<=100
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
	public Duration getactiveButtonMaxTime(int n)
	{
		return activeButtonMaxTime.get(n);
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
	public void setAllCaracteristiques(ArrayList<Boolean> b, double cheat)	//calcule les nouvelles valeurs des caracteristiques
	{
		//     -----     bouton actifs     -----
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

		//     -----     evolution caracteristiques avec le temps     -----     

		for(int i=0;i<6;i++)
		{
			this.setCaracteristique(i, this.getCaracteristique(i)+CaractTimeSpeed.get(i)*0.05*cheat);
		}

		//     -----     evolution caracteristiques avec les boutons     -----     
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
		//     -----     evolution de la vie     -----     
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
		//     -----     evolution de l'etat physique     -----     
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
		if(this.getCaracteristique(5)<30)
		{
			etatPhysique="Triste";
		}
		else if(this.getCaracteristique(5)<10)
		{
			etatPhysique="Désespéré";
		}
		else if(this.getCaracteristique(5)>80)
		{
			etatPhysique="Heureux";
		}
		else
		{
			etatPhysique="Content";
		}
	}
	public void setAllCaracteristiquesRestart(long time, int dodo, long dtDodo)
	{
		long dt=Instant.now().getEpochSecond()-time;
		for(int i=0;i<6;i++)
		{
			this.setCaracteristique(i, this.getCaracteristique(i)+CaractTimeSpeed.get(i)*dt);//effectue le calcul pour dt secondes
		}
		if(dodo==1)
		{
			if(time+dtDodo<Instant.now().getEpochSecond())
			{
				this.setCaracteristique(2, this.getCaracteristique(2)+activeButtonSpeed.get(1).get(2)*dtDodo);//effectue le calcul pour dt secondes de sommeil restant
				this.setActiveButton(1, false);
			}
			else
			{
				this.setActiveButton(1, true);
				this.setCaracteristique(2, this.getCaracteristique(2)+activeButtonSpeed.get(1).get(2)*(Instant.now().getEpochSecond()-time));
				this.setActiveButtonTime(1, Instant.ofEpochSecond(time));
			}
		}
	}


}
