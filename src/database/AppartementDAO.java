package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import metier.Appartement;

/**
 *
 * @author garmy
 */
public class AppartementDAO {

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

    public void addAppartement(Appartement appartement) {
        Connection conn = SingletonConnection.getConnection("thies");
        try {
            PreparedStatement ps = conn.prepareStatement("insert into table_maison values(?,?,?,?,?,?,?)");
            // on ecrire une requette d'insertion sur tous les table.
            /*ps.setString(1, maison.getType());
			ps.setInt(2, maison.getPrix());
			ps.setInt(3, maison.getNombreChambre());
			ps.setInt(4, maison.getNombreBain());
			ps.setInt(5, maison.getNombreSalon());
			ps.setString(6, maison.getLatitude());
			ps.setString(7, maison.getLongitude());*/
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
