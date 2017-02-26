package database;

import java.util.List;

import metier.Logement;

public class TestMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        LogementDAO impl = new LogementDAO();
        Logement l = new Logement();
        l.setLatitude("12.01452jjjj");
        l.setLongitude("-17.123652");
        l.setNombreBain(2);
        l.setNombreChambre(5);
        l.setNombreSalon(1);
        l.setPrix(150000);
        l.setType("batiment");
        //impl.addLogement(l);
        List<Logement> list = impl.listBatiments();
        for (Logement logement : list) {
            System.out.println(logement.getLatitude());
        }
        //impl.deleteLogement(5);
    }
}
