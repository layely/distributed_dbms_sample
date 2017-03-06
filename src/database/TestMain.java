package database;

import metier.Proprietaire;

public class TestMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("debut de la fonction");
        ProprietaireDAO impl = new ProprietaireDAO();
        Proprietaire p = new Proprietaire();
        p.setNumProprietaire(1);
        p.setNom("diakhoumpa");
        p.setPrenom("matar");
        p.setAddress("Dakr parcelle assainie");
        p.setMail("matar@gmail.com");
        p.setPassword("monpassword");
        p.setTel("77 247 93 33");
        impl.addProprietaire(p);

        /* List<Logement > list = impl.listBatiments();
        for (Logement logement : list) {
            System.out.println(logement.getLatitude());
        }*/
        //impl.deleteLogement(5);
    }
}
