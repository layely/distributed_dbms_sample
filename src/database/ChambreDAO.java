/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
