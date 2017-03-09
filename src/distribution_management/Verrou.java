/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribution_management;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author layely
 */
public class Verrou {

    public static final Integer READ = 0;
    public static final Integer WRITE = 1;

    public static ReentrantReadWriteLock tableProprietaireVerrou;
    public static ReentrantReadWriteLock tableLogementVerrou;

    static {
        tableProprietaireVerrou = new ReentrantReadWriteLock();
        tableLogementVerrou = new ReentrantReadWriteLock();
    }
}
