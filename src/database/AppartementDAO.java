package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import metier.Appartement;

/**
 *
 * @author garmy
 */
public class AppartementDAO {

    public ArrayList<Appartement> listAppartementT() {
        ArrayList<Appartement> list = new ArrayList<Appartement>();
        Connection connection = SingletonConnection.getConnection("thies");
        try {
            PreparedStatement ps = connection.prepareStatement("select * from table_logement,table_appartement,table_multiPiece where table_logement.numLogement=table_appartement.numAppartement and  table_logement.numLogement=table_multiPiece.numMultiPiece");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Appartement appartement = new Appartement();
                appartement.setNumLogement(rs.getInt("numLogement"));
                appartement.setAddress(rs.getString("address"));
                appartement.setDescription(rs.getString("description"));
                appartement.setNombreBalcon(rs.getInt("nombreBalcon"));
                appartement.setNombreChambre(rs.getInt("nombreChambre"));
                appartement.setNombreCuisine(rs.getInt("nombreCuisine"));
                appartement.setNombreToilette(rs.getInt("nombreToilette"));
                appartement.setNumProprietaire(rs.getInt("numProprietaire"));
                appartement.setNumVille(rs.getInt("numVille"));
                appartement.setPrix(rs.getInt("prix"));
                appartement.setSurface(rs.getDouble("surface"));
                list.add(appartement);
            }
            ps.close();
            return list;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Appartement> listAppartementD() {
        ArrayList<Appartement> list = new ArrayList<Appartement>();
        Connection connection = SingletonConnection.getConnection("dakar");
        try {
            PreparedStatement ps = connection.prepareStatement("select * from table_logement,table_appartement,table_multiPiece where table_logement.numLogement=table_appartement.numAppartement and  table_logement.numLogement=table_multiPiece.numMultiPiece");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Appartement appartement = new Appartement();
                appartement.setNumLogement(rs.getInt("numLogement"));
                appartement.setAddress(rs.getString("address"));
                appartement.setDescription(rs.getString("description"));
                appartement.setNombreBalcon(rs.getInt("nombreBalcon"));
                appartement.setNombreChambre(rs.getInt("nombreChambre"));
                appartement.setNombreCuisine(rs.getInt("nombreCuisine"));
                appartement.setNombreToilette(rs.getInt("nombreToilette"));
                appartement.setNumProprietaire(rs.getInt("numProprietaire"));
                appartement.setNumVille(rs.getInt("numVille"));
                appartement.setPrix(rs.getInt("prix"));
                appartement.setSurface(rs.getDouble("surface"));
                list.add(appartement);
            }
            ps.close();
            return list;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public void deleteAppartement(int id) {
        Connection conn = SingletonConnection.getConnection("thies");
        try {
            PreparedStatement ps = conn.prepareStatement("delete from logement where id=?");
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

    public void addAppartement(Appartement appartement, String ville) {
        Connection conn = SingletonConnection.getConnection(ville);

        try {
            PreparedStatement ps = conn.prepareStatement("insert into table_logement values(?,?,?,?,?,?,?)");
            // on ecrire une requette d'insertion sur tous les table.
            ps.setInt(1, appartement.getNumLogement());
            ps.setString(2, appartement.getDescription());
            ps.setInt(3, appartement.getPrix());
            ps.setInt(4, appartement.getNumVille());
            ps.setString(5, appartement.getAddress());
            ps.setInt(6, appartement.getNumProprietaire());
            ps.setDouble(7, appartement.getSurface());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = conn.prepareStatement("insert into table_multiPiece values(?,?,?,?,?)");
            // on ecrire une requette d'insertion sur tous les table.

            ps.setInt(1, appartement.getNumLogement());
            ps.setInt(2, appartement.getNombreBalcon());
            ps.setInt(3, appartement.getNombreChambre());
            ps.setInt(4, appartement.getNombreToilette());
            ps.setInt(5, appartement.getNombreCuisine());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = conn.prepareStatement("insert into table_appartement values(?,?)");
            // on ecrire une requette d'insertion sur tous les table.
            ps.setInt(1, appartement.getNumLogement());
            ps.setInt(2, appartement.getEtage());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public Appartement getAppartement(int id) {
        Appartement appartement = new Appartement();
        Connection connection = SingletonConnection.getConnection("thies");
        try {
            PreparedStatement ps = connection.prepareStatement("select * from table_logement,table_appartement,table_multiPiece where table_logement.numLogement=table_appartement.numAppartement and table_mulitPiece.numMultiPiece=table_appartement.numAppartement and table_Appartement.numMaison=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            appartement.setNumLogement(rs.getInt("numLogement"));
            appartement.setAddress(rs.getString("address"));
            appartement.setDescription(rs.getString("description"));
            appartement.setNombreBalcon(rs.getInt("nombrebalcon"));
            appartement.setNombreChambre(rs.getInt("nombreChambre"));
            appartement.setNombreCuisine(rs.getInt("nombreCuisine"));
            appartement.setNombreToilette(rs.getInt("nombreToilette"));
            appartement.setNumProprietaire(rs.getInt("numProprietaire"));
            appartement.setNumVille(rs.getInt("numVille"));
            appartement.setPrix(rs.getInt("prix"));
            appartement.setSurface(rs.getDouble("surface"));
            appartement.setEtage(rs.getInt("etage"));
            ps.close();
            return appartement;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

}
