package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import metier.Maison;

public class MaisonDAO {

    public static int index = 0;

    public void deleteMaison(int id) {
        Connection conn = SingletonConnection.getConnection("dakar");
        try {
            PreparedStatement ps = conn.prepareStatement("delete from table_maison where id=?");
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

        try {
            PreparedStatement ps = conn.prepareStatement("delete from table_multiPiece where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void addMaison(Maison maison, String ville) {
        Connection conn = SingletonConnection.getConnection(ville);
        System.out.println("dans addMaison");
        try {
            PreparedStatement ps = conn.prepareStatement("insert into table_logement values(?,?,?,?,?,?,?)");
            // on ecrire une requette d'insertion sur tous les table.
            ps.setInt(1, maison.getNumLogement());
            ps.setString(2, maison.getDescription());
            ps.setInt(3, maison.getPrix());
            ps.setInt(4, maison.getNumVille());
            ps.setString(5, maison.getAddress());
            ps.setInt(6, maison.getNumProprietaire());
            ps.setDouble(7, maison.getSurface());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = conn.prepareStatement("insert into table_multiPiece values(?,?,?,?,?)");
            // on ecrire une requette d'insertion sur tous les table.

            ps.setInt(1, maison.getNumLogement());
            ps.setInt(2, maison.getNombreBalcon());
            ps.setInt(3, maison.getNombreChambre());
            ps.setInt(4, maison.getNombreToilette());
            ps.setInt(5, maison.getNombreCuisine());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = conn.prepareStatement("insert into table_maison values(?,?,?,?)");
            // on ecrire une requette d'insertion sur tous les table.
            ps.setInt(1, maison.getNumLogement());
            ps.setInt(2, maison.getNombreEtage());
            ps.setInt(3, maison.getNombreParking());
            ps.setString(4, maison.getDescription());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public Maison getMaison(int id) {
        Maison maison = new Maison();
        Connection connection = SingletonConnection.getConnection("thies");
        try {
            PreparedStatement ps = connection.prepareStatement("select * from table_logement,table_maison where table_logement.numLogement=table_maison.numMaison and table_maison.numMaison=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            maison.setNumLogement(rs.getInt("numLogement"));
            maison.setAddress(rs.getString("address"));
            maison.setDescription(rs.getString("description"));
            maison.setNombreBalcon(rs.getInt("nombrebalcon"));
            maison.setNombreChambre(rs.getInt("nombreChambre"));
            maison.setNombreCuisine(rs.getInt("nombreCuisine"));
            maison.setNombreToilette(rs.getInt("nombreToilette"));
            maison.setNumProprietaire(rs.getInt("numProprietaire"));
            maison.setNumVille(rs.getInt("numVille"));
            maison.setPrix(rs.getInt("prix"));
            maison.setSurface(rs.getDouble("surface"));
            maison.setNombreEtage(rs.getInt("nombreEtage"));
            maison.setDateConstruction(rs.getString("dateConstruction"));
            maison.setNombreParking(rs.getInt("nombreNombreParking"));
            ps.close();
            return maison;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Maison> listMaisonD() {
        ArrayList<Maison> list = new ArrayList<Maison>();
        Connection connection = SingletonConnection.getConnection("dakar");
        try {
            PreparedStatement ps = connection.prepareStatement("select * from table_logement,table_maison,table_multiPiece where table_logement.numLogement=table_maison.numMaison and  table_logement.numLogement=table_multiPiece.numMultiPiece");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Maison maison = new Maison();
                maison.setNumLogement(rs.getInt("numLogement"));
                maison.setAddress(rs.getString("address"));
                maison.setDescription(rs.getString("description"));
                maison.setNombreBalcon(rs.getInt("nombreBalcon"));
                maison.setNombreChambre(rs.getInt("nombreChambre"));
                maison.setNombreCuisine(rs.getInt("nombreCuisine"));
                maison.setNombreToilette(rs.getInt("nombreToilette"));
                maison.setNumProprietaire(rs.getInt("numProprietaire"));
                maison.setNumVille(rs.getInt("numVille"));
                maison.setPrix(rs.getInt("prix"));
                maison.setSurface(rs.getDouble("surface"));
                list.add(maison);
            }
            ps.close();
            return list;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Maison> listMaisonT() {
        ArrayList<Maison> list = new ArrayList<Maison>();
        Connection connection = SingletonConnection.getConnection("thies");
        try {
            PreparedStatement ps = connection.prepareStatement("select * from table_logement,table_maison,table_multiPiece where table_logement.numLogement=table_maison.numMaison and  table_logement.numLogement=table_multiPiece.numMultiPiece");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Maison maison = new Maison();
                maison.setNumLogement(rs.getInt("numLogement"));
                maison.setAddress(rs.getString("address"));
                maison.setDescription(rs.getString("description"));
                maison.setNombreBalcon(rs.getInt("nombreBalcon"));
                maison.setNombreChambre(rs.getInt("nombreChambre"));
                maison.setNombreCuisine(rs.getInt("nombreCuisine"));
                maison.setNombreToilette(rs.getInt("nombreToilette"));
                maison.setNumProprietaire(rs.getInt("numProprietaire"));
                maison.setNumVille(rs.getInt("numVille"));
                maison.setPrix(rs.getInt("prix"));
                maison.setSurface(rs.getDouble("surface"));
                list.add(maison);
            }
            ps.close();
            return list;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

}
