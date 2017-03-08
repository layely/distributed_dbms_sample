package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import metier.Proprietaire;

public class ProprietaireDAO {

//    public void addProprietaireD(Proprietaire p) {
//        Connection connec = SingletonConnection.getConnection("dakar");
//
//        try {
//            PreparedStatement ps = connec.prepareStatement("insert into table_proprietaire(numProprietaire,nom,prenom,address,tel,mail,password) values(?,?,?,?,?,?,?)");
//            ps.setInt(1, p.getNumProprietaire());
//            ps.setString(2, p.getNom());
//            ps.setString(3, p.getPrenom());
//            ps.setString(4, p.getAddress());
//            ps.setString(5, p.getTel());
//            ps.setString(6, p.getMail());
//            ps.setString(7, p.getPassword());
//            ps.executeUpdate();
//            ps.close();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }
    public void addProprietaire(String v, Proprietaire p) {
        Connection conn = SingletonConnection.getConnection(v);

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
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public ArrayList<Proprietaire> getProprietaire() {
        ArrayList<Proprietaire> list = new ArrayList<Proprietaire>();
        Connection connection = SingletonConnection.getConnection("thies");
        try {
            PreparedStatement ps = connection.prepareStatement("select * from table_proprietaire");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Proprietaire p = new Proprietaire();
                p.setNumProprietaire(rs.getInt("numProprietaire"));
                p.setAddress(rs.getString("address"));
                p.setMail(rs.getString("mail"));
                p.setNom(rs.getString("nom"));
                p.setPassword(rs.getString("password"));
                p.setPrenom(rs.getString("prenom"));
                p.setTel(rs.getString("tel"));

                list.add(p);
            }

            ps.close();
            return list;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    public Proprietaire getProprietaire(String mail, String password) {
        Proprietaire p = new Proprietaire();
        Connection connection = SingletonConnection.getConnection("thies");
        try {
            PreparedStatement ps = connection.prepareStatement("select * from table_proprietaire where table_proprietaire.mail=? and table_proprietaire.password=?");
            ps.setString(1, mail);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            p.setNumProprietaire(rs.getInt("numProprietaire"));
            p.setNom(rs.getString("nom"));
            p.setPrenom(rs.getString("prenom"));
            p.setAddress(rs.getString("address"));
            p.setTel(rs.getString("tel"));
            p.setMail(rs.getString("mail"));
            System.out.println(rs.getInt("numProprietaire"));
            /* if (rs.getInt("numProprietaire") == null) {
                ps.close();
                return null;
            } else {
                ps.close();
                return p;
            }*/
            return p;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

}
