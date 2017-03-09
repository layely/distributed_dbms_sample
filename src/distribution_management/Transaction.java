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
public abstract class Transaction implements Runnable {

    private LinkedList<ReentrantReadWriteLock> verrous;

    public Transaction() {
        verrous = new LinkedList<>();
    }

    @Override
    public abstract void run();

    public void libererVerous() {
        for (ReentrantReadWriteLock v : verrous) {
            if (v.isWriteLockedByCurrentThread()) {
                v.readLock().lock();
            }
            v.readLock().unlock();
        }
    }

    protected void addVerrou(ReentrantReadWriteLock v) {
        this.verrous.add(v);
    }
}
