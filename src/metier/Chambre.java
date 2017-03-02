package metier;

public class Chambre extends Logement {

    private int numChambre;
    private int nombreBalcon;
    private int nombreToilette;

    public int getNumChambre() {
        return numChambre;
    }

    public int getNombreBalcon() {
        return nombreBalcon;
    }

    public void setNombreBalcon(int nombreBalcon) {
        this.nombreBalcon = nombreBalcon;
    }

    public int getNombreToilette() {
        return nombreToilette;
    }

    public void setNombreToilette(int nombretoilette) {
        this.nombreToilette = nombretoilette;
    }

    public void setNumChambre(int numChambre) {
        this.numChambre = numChambre;
    }

    public Chambre(int numChambre) {
        super();
        this.numChambre = numChambre;
    }

}
