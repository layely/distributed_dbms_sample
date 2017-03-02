package database;

import metier.Maison;

public class TestMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("debut de la fonction");
        MaisonDAO impl = new MaisonDAO();
        Maison maison = new Maison();
        maison.setAddress("dakar");
        maison.setDateConstruction("12/12/63");
        maison.setDescription("ceci est une description");
        maison.setNombreBalcon(2);
        maison.setNombreChambre(5);
        maison.setNombreCuisine(1);
        maison.setNombreEtage(2);
        maison.setNombreParking(1);
        maison.setNombreToilette(2);
        maison.setNumLogement(database.MaisonDAO.logement_id);
        maison.setNumProprietaire(1);
        maison.setNumVille(1);
        maison.setPrix(150000);
        maison.setSurface(5000);
        impl.addMaison(maison);

        /* List<Logement > list = impl.listBatiments();
        for (Logement logement : list) {
            System.out.println(logement.getLatitude());
        }*/
        //impl.deleteLogement(5);
    }
}
