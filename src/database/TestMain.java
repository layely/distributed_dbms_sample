package database;

import metier.Maison;

public class TestMain {

    /**
     * @param
     */
    public static void main(String[] args) {
        System.out.println("debut de la fonction");
        MaisonDAO impl = new MaisonDAO();
        Maison m = new Maison();
        m.setAddress("dakar");
        m.setDateConstruction("22/12/1993");
        m.setDescription("la description");
        m.setNombreBalcon(1);
        m.setNombreChambre(16);
        m.setNombreCuisine(0);
        m.setNombreEtage(14);
        m.setNombreParking(2);
        m.setNombreToilette(4);
        m.setNumLogement(4);
        m.setNumProprietaire(1);
        m.setNumVille(1);
        m.setPrix(150000);
        m.setSurface(451);
        impl.addMaison(m, "thies");
        /*IdLogement id = new IdLogement();
        System.out.println(id.getId());*/


 /* List<Logement > list = impl.listBatiments();
        for (Logement logement : list) {
            System.out.println(logement.getLatitude());
        }*/
        //impl.deleteLogement(5);
    }
}
