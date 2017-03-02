package metier;

public class Ville {

    private int numVille;
    private double superficie;
    private int population;
    private String nom;

    public Ville(int numVille, double superficie, int population) {
        super();
        this.numVille = numVille;
        this.superficie = superficie;
        this.population = population;
    }

    public int getNumVille() {
        return numVille;
    }

    public void setNumVille(int numVille) {
        this.numVille = numVille;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

}
