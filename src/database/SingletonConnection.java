package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SingletonConnection {

    //Information de la connexion au fragment centrale.
    private static final String CENTRALE_IP_ADDR = "localhost";
    private static final String CENTRALE_DB_NAME = "central";
    private static final String CENTRALE_PORT = "3306";
    private static final String CENTRALE_USERNAME = "gl";
    private static final String CENTRALE_PASSWORD = "gl";

    private static final String TABLE_CONNECTION_INFO = "ConnectionInfo";
    private static final String COLONE_CONNECTION_INFO_SITE = "site";
    private static final String COLONE_CONNECTION_INFO_IP_ADDR = "ip_addr";
    private static final String COLONE_CONNECTION_INFO_DB_NAME = "db_name";
    private static final String COLONE_CONNECTION_INFO_PORT = "port";
    private static final String COLONE_CONNECTION_INFO_USERNAME = "username";
    private static final String COLONE_CONNECTION_INFO_PASSWORD = "password";

    public static final String KEY_LAST_ID_LOGEMENT = "last_id_logement";
    public static final String KEY_LAST_ID_PROPRIETAIRE = "last_id_proprietaire";

    //Object de connection à la BD centrale;
    private static Connection connectionCentrale = null;

    /**
     * ******************************************************
     **
     ** Recuperer un objet connection d'un site (ville) *
     * *****************************************************
     */
    public static Connection getConnection(String ville) {
        List<String> infos = getSiteInfoConnection(ville);

        String ipAddr = infos.get(1);
        String dbName = infos.get(2);
        String port = infos.get(3);
        String username = infos.get(4);
        String password = infos.get(5);

        return getConnectionUsing(ipAddr, dbName, port, username, password);
    }

    private static Connection getConnectionFromFragmentCentrale() {
        if (connectionCentrale == null) {
            connectionCentrale = getConnectionUsing(CENTRALE_IP_ADDR, CENTRALE_DB_NAME, CENTRALE_PORT, CENTRALE_USERNAME, CENTRALE_PASSWORD);
        }

        return connectionCentrale;
    }

    private static Connection getConnectionUsing(String ipAddr, String dbname, String port,
            String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://" + ipAddr + ":" + port + "/" + dbname, username, password);
            return connection;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    /*
    *   Recuperer les informations de connexion d'un site (nom, ip, port, login et mot de passe)
    **
     */
    private static List<String> getSiteInfoConnection(String ville) {
        ville = ville.toUpperCase();
        List<String> infos = null;
        String requete = "SELECT * FROM " + TABLE_CONNECTION_INFO + " WHERE " + COLONE_CONNECTION_INFO_SITE + " = ?";

        PreparedStatement statmnt = null;
        ResultSet resultats = null;
        try {
            statmnt = getConnectionFromFragmentCentrale().prepareStatement(requete);
            statmnt.setString(1, ville);
            resultats = statmnt.executeQuery();

            if (resultats.next()) {

                String site = resultats.getString(COLONE_CONNECTION_INFO_SITE);
                String ipAddr = resultats.getString(COLONE_CONNECTION_INFO_IP_ADDR);
                String dbName = resultats.getString(COLONE_CONNECTION_INFO_DB_NAME);
                String port = resultats.getString(COLONE_CONNECTION_INFO_PORT);
                String username = resultats.getString(COLONE_CONNECTION_INFO_USERNAME);
                String password = resultats.getString(COLONE_CONNECTION_INFO_PASSWORD);

                infos = new ArrayList<>(6);
                infos.add(site);
                infos.add(ipAddr);
                infos.add(dbName);
                infos.add(port);
                infos.add(username);
                infos.add(password);
            }
            resultats.close();
            statmnt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return infos;
        }
    }

    public static String getValue(String key) {
        String valeur = "-1";
        Connection conn = SingletonConnection.getConnectionFromFragmentCentrale();
        try {
            PreparedStatement ps = conn.prepareStatement("select valeur from parametres where cle='" + key + "'");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                valeur = rs.getString("valeur");
            }
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return valeur;
    }

    public static int getIntValue(String key) {
        String valStr = getValue(key);
        try {
            return Integer.parseInt(valStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void setValue(String key, String newValue) {
        Connection conn = SingletonConnection.getConnectionFromFragmentCentrale();
        try {
            PreparedStatement ps = conn.prepareStatement("update  parametres set valeur=? where cle = '" + key + "'");
            ps.setString(1, newValue);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
