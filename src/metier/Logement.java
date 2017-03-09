package metier;

import java.io.Serializable;

<<<<<<< HEAD
public class Logement implements Serializable{
	
	private int numLogement;
	private String description;
	private int prix;
	private String nomVille;
	private String address;
	private int numProprietaire;
	private double surface;
	
	public int getNumProprietaire() {
		return numProprietaire;
	}
	public void setNumProprietaire(int numProprietaire) {
		this.numProprietaire = numProprietaire;
	}
	public double getSurface() {
		return surface;
	}
	public void setSurface(double surface) {
		this.surface = surface;
	}
	
	public int getNumLogement() {
		return numLogement;
	}
	public void setNumLogement(int numLogement) {
		this.numLogement = numLogement;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getNumVille() {
		return nomVille;
	}
	public void setNumVille(String nomVille) {
		this.nomVille = nomVille;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
=======
public class Logement implements Serializable {

    private int numLogement;
    private String description;
    private int prix;
    private String nomVille;
    private String address;
    private int numProprietaire;
    private double surface;

    public int getNumProprietaire() {
        return numProprietaire;
    }

    public void setNumProprietaire(int numProprietaire) {
        this.numProprietaire = numProprietaire;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public int getNumLogement() {
        return numLogement;
    }

    public void setNumLogement(int numLogement) {
        this.numLogement = numLogement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

>>>>>>> a925c80892a10d9f1281b3e8e239164ad6de859e
}
