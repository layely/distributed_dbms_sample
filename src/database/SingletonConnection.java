package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SingletonConnection {

    //Information de la connexion au fragment centrale.
    private static final String CENTRALE_IP_ADDR = "localhost";
    private static final String CENTRALE_DB_NAME = "locationThies";
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
        if (connectionCentrale != null) {
            connectionCentrale = getConnectionUsing(CENTRALE_IP_ADDR, CENTRALE_DB_NAME, CENTRALE_PORT, CENTRALE_USERNAME, CENTRALE_PASSWORD);
        }

        return connectionCentrale;
    }

    private static Connection getConnectionUsing(String ipAddr, String dbname, String port,
            String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            /*Connection connection = DriverManager.getConnection("jdbc:mysql://" + ipAddr
                    + ":3306/" + dbname, username, password);*/
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/locationthies", "root", "456153");
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

}
