package database;

import java.util.ArrayList;
import metier.Proprietaire;

public class TestMain {

    /**
     * @param
     */
    public static void main(String[] args) {
        System.out.println("debut de la fonction");
        ProprietaireDAO impl = new ProprietaireDAO();
        ArrayList<Proprietaire> list = new ArrayList<Proprietaire>();
        Proprietaire p = new Proprietaire();
        list = impl.getProprietaire();

        System.out.println(list.get(0).getNom());

        /* List<Logement > list = impl.listBatiments();
        for (Logement logement : list) {
            System.out.println(logement.getLatitude());
        }*/
        //impl.deleteLogement(5);
    }
}
