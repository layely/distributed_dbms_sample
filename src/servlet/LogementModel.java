package servlet;

import java.util.ArrayList;
import metier.Appartement;
import metier.Chambre;
import metier.Maison;
import metier.Proprietaire;

public class LogementModel {

    private ArrayList<Maison> maisons = new ArrayList<Maison>();
    private ArrayList<Appartement> appartements = new ArrayList<Appartement>();
    private ArrayList<Chambre> chambres = new ArrayList<Chambre>();
    private ArrayList<Proprietaire> proprietaires = new ArrayList<Proprietaire>();

    public ArrayList<Maison> getMaisons() {
        return maisons;
    }

    public void setMaisons(ArrayList<Maison> maisons) {
        this.maisons = maisons;
    }

    public ArrayList<Appartement> getAppartements() {
        return appartements;
    }

    public void setAppartements(ArrayList<Appartement> appartements) {
        this.appartements = appartements;
    }

    public ArrayList<Chambre> getChambres() {
        return chambres;
    }

    public void setChambres(ArrayList<Chambre> chambres) {
        this.chambres = chambres;
    }

    public ArrayList<Proprietaire> getProprietaires() {
        return proprietaires;
    }

    public void setProprietaires(ArrayList<Proprietaire> proprietaires) {
        this.proprietaires = proprietaires;
    }

}
