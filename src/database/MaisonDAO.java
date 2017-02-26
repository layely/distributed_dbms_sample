package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Logement;
import metier.Maison;

public class MaisonDAO {

    public void deleteMaison(int id) {
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

    }

    public void addMaison(Maison maison) {
        Connection conn = SingletonConnection.getConnection("thies");
        try {
            PreparedStatement ps = conn.prepareStatement("insert into table_maison(type,prix,chambre,bain,salon,latitude,longitude) values(?,?,?,?,?,?,?)");
            // on ecrire une requette d'insertion sur tous les table.
            /*ps.setString(1, l.getType());
			ps.setInt(2, l.getPrix());
			ps.setInt(3, l.getNombreChambre());
			ps.setInt(4, l.getNombreBain());
			ps.setInt(5, l.getNombreSalon());
			ps.setString(6, l.getLatitude());
			ps.setString(7, l.getLongitude());*/
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
            maison.setParking(rs.getInt("nombreParking"));
            maison.setPrix(rs.getInt("prix"));
            maison.setSurface(rs.getDouble("surface"));
            ps.close();
            return maison;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Maison> listMaison() {
        ArrayList<Maison> list = new ArrayList<Maison>();
        Connection connection = SingletonConnection.getConnection("thies");
        try {
            PreparedStatement ps = connection.prepareStatement("select * from table_logement,table_maison where table_logement.numLogement=table_maison.numMaison");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Maison maison = new Maison();
                maison.setNumLogement(rs.getInt("numLogement"));
                maison.setAddress(rs.getString("address"));
                maison.setDescription(rs.getString("description"));
                maison.setNombreBalcon(rs.getInt("nombrebalcon"));
                maison.setNombreChambre(rs.getInt("nombreChambre"));
                maison.setNombreCuisine(rs.getInt("nombreCuisine"));
                maison.setNombreToilette(rs.getInt("nombreToilette"));
                maison.setNumProprietaire(rs.getInt("numProprietaire"));
                maison.setNumVille(rs.getInt("numVille"));
                maison.setParking(rs.getInt("nombreParking"));
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
