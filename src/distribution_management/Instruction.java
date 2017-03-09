/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribution_management;

/**
 *
 * @author layely
 */
class Instruction {

    public static final int TYPE_QUERRY = 0;
    public static final int TYPE_UPDATE = 1;

    private int type;
    private String chaine;

    public Instruction(int type, String chaine) {
        this.type = type;
        this.chaine = chaine;
    }

    public int getType() {
        return type;
    }

    public String getChaine() {
        return chaine;
    }

}
