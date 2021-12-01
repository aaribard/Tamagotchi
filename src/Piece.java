import java.util.ArrayList;

public class Piece {
	private int id;
	private String nom;
	private static int nbPieces;
	private ArrayList<Piece> pieceAdja;
	
	public Piece(String n)
	{
		id=nbPieces++;
		nom=n;
		pieceAdja= new ArrayList<Piece>();
	}
	public int getId()
	{
		return id;
	}
	public String getNom()
	{
		return nom;
	}
	public int getNbPieces()
	{
		return nbPieces;
	}
	public void addPieceAdja(Piece p)
	{
		pieceAdja.add(p);
	}
	public ArrayList<Piece> getPieceAdja()
	{
		return pieceAdja;
	}
	public ArrayList<Piece> getPieceAdjaId()
	{
		return pieceAdja;
	}
}
