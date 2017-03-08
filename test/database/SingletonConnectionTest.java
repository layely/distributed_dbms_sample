/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;

/**
 *
 * @author layely
 */
public class SingletonConnectionTest {

    public static void main(String[] args) {
        Connection connectionToDakar = SingletonConnection.getConnection("thies");
    }
}
