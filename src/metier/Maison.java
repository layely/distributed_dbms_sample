package metier;

public class Maison extends MultiPiece {

    private int nombreEtage;
    private int nombreParking;
    private String dateConstruction;  //format dd/mm/yyyy

    public int getNombreEtage() {
        return nombreEtage;
    }

    public void setNombreEtage(int nombreEtage) {
        this.nombreEtage = nombreEtage;
    }

    public int getNombreParking() {
        return nombreParking;
    }

    public void setNombreParking(int nombreParking) {
        this.nombreParking = nombreParking;
    }

    public String getDateConstruction() {
        return dateConstruction;
    }

    public void setDateConstruction(String dateConstruction) {
        this.dateConstruction = dateConstruction;
    }

}
