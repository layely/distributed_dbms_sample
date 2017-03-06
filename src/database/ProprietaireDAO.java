package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import metier.Proprietaire;

public class ProprietaireDAO {

    public void addProprietaire(Proprietaire p) {
        Connection conn = SingletonConnection.getConnection("thies");
        System.out.println("dans addProprietaire");
        try {
            PreparedStatement ps = conn.prepareStatement("insert into table_proprietaire(numProprietaire,nom,prenom,address,tel,mail,password) values(?,?,?,?,?,?,?)");
            ps.setInt(1, p.getNumProprietaire());
            ps.setString(2, p.getNom());
            ps.setString(3, p.getPrenom());
            ps.setString(4, p.getAddress());
            ps.setString(5, p.getTel());
            ps.setString(6, p.getMail());
            ps.setString(7, p.getPassword());
            ps.executeUpdate();
            ps.close();
            System.out.println("database.ProprietaireDAO.addProprietaire()");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public Proprietaire getProprietaire(int id) {
        Proprietaire p = new Proprietaire();
        Connection connection = SingletonConnection.getConnection("thies");
        try {
            PreparedStatement ps = connection.prepareStatement("select * from table_proprietairewhere table_proprietaire.nu;Proprietaire=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            p.setNumProprietaire(rs.getInt("numProprietaire"));
            p.setNom(rs.getString("nom"));
            p.setPrenom(rs.getString("prenom"));
            p.setAddress(rs.getString("address"));
            p.setTel(rs.getString("tel"));
            p.setMail(rs.getString("mail"));

            ps.close();
            return p;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

}
