/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import metier.Proprietaire;

/**
 *
 * @author layely
 */
public class ProprietaireTest {

    public static void main(String[] args) {
        ProprietaireDAO propDAO = new ProprietaireDAO();
        Proprietaire p = propDAO.getProprietaire("el", "pass");

        if (p == null) {
            System.out.println("---------------------- Null");
        } else {
            System.out.println("------------------- " + p.getNom());
        }
    }
}
