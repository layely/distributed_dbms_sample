package metier;

public class Chambre extends Logement {

    private int nombreBalcon;
    private int nombreToilette;

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

}
