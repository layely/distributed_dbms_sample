package database;

import java.util.List;

import metier.Logement;

public interface intlog {

    public Logement getLogement(int id);

    public void addLogement(Logement logement);

    public List<Logement> listlogements();

    public List<Logement> listAppartement();

    public List<Logement> listMaison();

    public List<Logement> listChambre();

    public void updateLogement(Logement l);

    public void deleteLogement(int id);
}
