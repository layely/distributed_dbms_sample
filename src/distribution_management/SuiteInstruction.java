/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribution_management;

import java.util.LinkedList;

/**
 *
 * @author layely
 */
public class SuiteInstruction {

    private int typeDeVerrou;
    private LinkedList<Instruction> instructions;

    public SuiteInstruction(int verrou, LinkedList<Instruction> instructions) {
        typeDeVerrou = verrou;
        this.instructions = instructions;
    }

    public int getTypeDeVerrou() {
        return typeDeVerrou;
    }

    public LinkedList<Instruction> getInstructions() {
        return instructions;
    }

}
