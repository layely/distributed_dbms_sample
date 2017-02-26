package database;

import java.sql.DriverManager;
import java.sql.Connection;

public class SingletonConnection {

    private static Connection connectionThies = null;
    private static Connection connectionDakar = null;

    private static Connection getConnection(String ipAddr, String dbname,
            String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://" + ipAddr
                    + ":3306/" + dbname, username, password);
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/database", "root", "");
            return connection;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    private static Connection getConnectionDakar() {
        if (connectionDakar == null) {
            connectionDakar = getConnection("localhost", "locationDakar", "root", "");
        }
        return connectionDakar;
    }

    private static Connection getConnectionThies() {
        if (connectionThies == null) {
            connectionThies = getConnection("localhost", "locationThies", "root", "");
        }
        return connectionThies;
    }

    public static Connection getConnection(String ville) {
        //TODO condition � v�rifier apres la creation de l'objet Ville;
        return getConnectionDakar();
    }
}
