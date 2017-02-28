package metier;

public class Appartement extends MultiPiece {

    private int etage;

    public Appartement() {
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public Appartement(int etage) {
        super();
        this.etage = etage;
    }

}
