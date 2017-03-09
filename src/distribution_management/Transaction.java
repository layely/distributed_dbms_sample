/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribution_management;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author layely
 */
public abstract class Transaction {

    private LinkedList<ReentrantReadWriteLock> verrous;
    private LinkedList<Integer> typeVerrous;

    public Transaction() {
        verrous = new LinkedList<>();
        typeVerrous = new LinkedList<>();
    }

    public abstract void run();

    public void libererVerous() {
        int i = 0;
        for (ReentrantReadWriteLock v : verrous) {
            if (typeVerrous.get(i) == Verrou.READ) {
                v.readLock().unlock();
            } else if (typeVerrous.get(i) == Verrou.WRITE) {
                v.writeLock();
            }
            i++;
//            if (v.isWriteLockedByCurrentThread()) {
//                v.writeLock().lock();
//            }
        }
    }

    protected void addVerrou(ReentrantReadWriteLock v, int type) {
        this.verrous.add(v);
        this.typeVerrous.add(type);
    }
}
