/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import metier.Chambre;

/**
 *
 * @author garmy
 */
public class ChambreDAO {

    public void deleteChambre(int id) {
        Connection conn = SingletonConnection.getConnection("thies");
        try {
            PreparedStatement ps = conn.prepareStatement("delete from table_chambre where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = conn.prepareStatement("delete from table_logement where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public ArrayList<Chambre> listMaisonT() {
        ArrayList<Chambre> list = new ArrayList<Chambre>();
        Connection connection = SingletonConnection.getConnection("thies");
        try {
            PreparedStatement ps = connection.prepareStatement("select * from table_logement,table_chambre where table_logement.numLogement=table_chambre.numChambre");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Chambre chambre = new Chambre();
                chambre.setNumLogement(rs.getInt("numLogement"));
                chambre.setAddress(rs.getString("address"));
                chambre.setDescription(rs.getString("description"));
                chambre.setNombreBalcon(rs.getInt("nombreBalcon"));

                chambre.setNumProprietaire(rs.getInt("numProprietaire"));
                chambre.setNumVille(rs.getInt("numVille"));
                chambre.setPrix(rs.getInt("prix"));
                chambre.setSurface(rs.getDouble("surface"));
                list.add(chambre);
            }
            ps.close();
            return list;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Chambre> listChambreT() {
        ArrayList<Chambre> list = new ArrayList<Chambre>();
        Connection connection = SingletonConnection.getConnection("thies");
        try {
            PreparedStatement ps = connection.prepareStatement("select * from table_logement,table_chambre where table_logement.numLogement=table_chambre.numChambre");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Chambre chambre = new Chambre();
                chambre.setNumLogement(rs.getInt("numLogement"));
                chambre.setAddress(rs.getString("address"));
                chambre.setDescription(rs.getString("description"));
                chambre.setNombreBalcon(rs.getInt("nombreBalcon"));

                chambre.setNumProprietaire(rs.getInt("numProprietaire"));
                chambre.setNumVille(rs.getInt("numVille"));
                chambre.setPrix(rs.getInt("prix"));
                chambre.setSurface(rs.getDouble("surface"));
                list.add(chambre);
            }
            ps.close();
            return list;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Chambre> listChambreD() {
        ArrayList<Chambre> list = new ArrayList<Chambre>();
        Connection connection = SingletonConnection.getConnection("dakar");
        try {
            PreparedStatement ps = connection.prepareStatement("select * from table_logement,table_chambre where table_logement.numLogement=table_chambre.numChambre");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Chambre chambre = new Chambre();
                chambre.setNumLogement(rs.getInt("numLogement"));
                chambre.setAddress(rs.getString("address"));
                chambre.setDescription(rs.getString("description"));
                chambre.setNombreBalcon(rs.getInt("nombreBalcon"));

                chambre.setNumProprietaire(rs.getInt("numProprietaire"));
                chambre.setNumVille(rs.getInt("numVille"));
                chambre.setPrix(rs.getInt("prix"));
                chambre.setSurface(rs.getDouble("surface"));
                list.add(chambre);
            }
            ps.close();
            return list;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public void addChambre(Chambre chambre, String ville) {
        Connection conn = SingletonConnection.getConnection(ville);
        System.out.println("dans addMaison");
        try {
            PreparedStatement ps = conn.prepareStatement("insert into table_logement values(?,?,?,?,?,?,?)");
            // on ecrire une requette d'insertion sur tous les table.
            ps.setInt(1, chambre.getNumLogement());
            ps.setString(2, chambre.getDescription());
            ps.setInt(3, chambre.getPrix());
            ps.setInt(4, chambre.getNumVille());
            ps.setString(5, chambre.getAddress());
            ps.setInt(6, chambre.getNumProprietaire());
            ps.setDouble(7, chambre.getSurface());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = conn.prepareStatement("insert into table_chambre values(?,?,?,?,?)");
            // on ecrire une requette d'insertion sur tous les table.

            ps.setInt(1, chambre.getNumLogement());
            ps.setInt(2, chambre.getNombreBalcon());
            ps.setInt(3, chambre.getNombreToilette());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
