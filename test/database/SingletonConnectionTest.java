/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author layely
 */
public class SingletonConnectionTest {

    public static void main(String[] args) {
        int lastValue = SingletonConnection.getIntValue(SingletonConnection.KEY_LAST_ID_LOGEMENT);
        System.out.println(lastValue);
        System.out.println("About to increment the value");
        SingletonConnection.setValue(SingletonConnection.KEY_LAST_ID_LOGEMENT, lastValue + 1 + "");
        lastValue = SingletonConnection.getIntValue(SingletonConnection.KEY_LAST_ID_LOGEMENT);
        System.out.println(lastValue);
    }
}
