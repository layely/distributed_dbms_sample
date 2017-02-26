package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Logement;

public class LogementDAO implements intlog {

    public static final String TABLE_LOGEMENT = "";

    @Override
    public List<Logement> listlogements() {
        List<Logement> lLogement = new ArrayList<Logement>();
        Connection connection = SingletonConnection.getConnection("thies");
        try {
            PreparedStatement ps = connection.prepareStatement("select * from logement");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Logement logement = new Logement();
                logement.setLatitude(rs.getString("latitude"));
                logement.setLongitude(rs.getString("longitude"));
                logement.setPrix(rs.getInt("prix"));
                logement.setNombreBain(rs.getInt("bain"));
                logement.setNombreChambre(rs.getInt("chambre"));
                logement.setNombreSalon(rs.getInt("salon"));
                logement.setType(rs.getString("type"));
                lLogement.add(logement);
            }
            ps.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return lLogement;
    }

    public List<Logement> listAppartement() {
        List<Logement> lAppartement = new ArrayList<Logement>();
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM logement WHERE type=?");
            ps.setString(1, "appartement");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Logement logement = new Logement();
                logement.setLatitude(rs.getString("latitude"));
                logement.setLongitude(rs.getString("longitude"));
                logement.setPrix(rs.getInt("prix"));
                logement.setNombreBain(rs.getInt("bain"));
                logement.setNombreChambre(rs.getInt("chambre"));
                logement.setNombreSalon(rs.getInt("salon"));
                logement.setType(rs.getString("type"));
                lAppartement.add(logement);
            }
            ps.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return lAppartement;
    }

    public List<Logement> listBatiments() {
        List<Logement> lBatiment = new ArrayList<Logement>();
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM logement WHERE type=?");
            ps.setString(1, "batiment");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Logement logement = new Logement();
                logement.setLatitude(rs.getString("latitude"));
                logement.setLongitude(rs.getString("longitude"));
                logement.setPrix(rs.getInt("prix"));
                logement.setNombreBain(rs.getInt("bain"));
                logement.setNombreChambre(rs.getInt("chambre"));
                logement.setNombreSalon(rs.getInt("salon"));
                logement.setType(rs.getString("type"));
                lBatiment.add(logement);
            }
            ps.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return lBatiment;
    }

    @Override
    public void addLogement(Logement l) {
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("insert into logement(type,prix,chambre,bain,salon,latitude,longitude) values(?,?,?,?,?,?,?)");
            ps.setString(1, l.getType());
            ps.setInt(2, l.getPrix());
            ps.setInt(3, l.getNombreChambre());
            ps.setInt(4, l.getNombreBain());
            ps.setInt(5, l.getNombreSalon());
            ps.setString(6, l.getLatitude());
            ps.setString(7, l.getLongitude());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public Logement getLogement(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    public void updateLogement(Logement l) {
        System.out.println("update");

    }

    public void deleteLogement(int id) {
        Connection conn = SingletonConnection.getConnection();
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

}
