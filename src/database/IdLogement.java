/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author garmy
 */
public class IdLogement {

//    public int getId() {
//        int id = 0;
//        Connection conn = SingletonConnection.getCentral();
//        try {
//            PreparedStatement ps = conn.prepareStatement("select * from parametres where cle='last_id_logement'");
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                id = rs.getInt("valeur");
//            }
//            ps.close();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        try {
//            PreparedStatement ps = conn.prepareStatement("update  parametres set valeur=?");
//            ps.setInt(1, id + 1);
//            ps.executeUpdate();
//
//            ps.close();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return id;
//    }
//
//    public int getIdP() {
//        int id = 0;
//        Connection conn = SingletonConnection.getConnectionFromFragmentCentrale();
//        try {
//            PreparedStatement ps = conn.prepareStatement("select * from parametres where cle='last_id_logement'");
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                id = rs.getInt("idProprietaire");
//            }
//            ps.close();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        try {
//            PreparedStatement ps = conn.prepareStatement("update  parametres set idProprietaire=?");
//            ps.setInt(1, id + 1);
//            ps.executeUpdate();
//
//            ps.close();
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return id;
//    }
}
