package edu.stevens.friccobo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Friend {
    private final String name;
    private final Lock lock = new ReentrantLock();

    public Friend(String name) {
        this.name = name;
    }

    public boolean impendingBow(Friend bower){
        boolean myLock = false;
        boolean yourLock = false;
        try {
            myLock = lock.tryLock();
            yourLock = bower.lock.tryLock();
        } finally {
            if (!(myLock && yourLock)){
                if(myLock){
                    lock.unlock();
                }

                if(yourLock){
                    bower.lock.unlock();
                }
            }
        }
        return myLock && yourLock;
    }

    public void bow(Friend bower){
        if(impendingBow(bower)) {
            try {
                System.out.format(
                        "%s: %s has bowed to me!%n",
                        this.name,
                        bower.name
                );
                bower.bowBack(this);
            } finally {
                this.lock.unlock();
                bower.lock.unlock();
            }
        } else {
            System.out.format(
                    "%s: %s started to bow to me,but I was already bowing to him",
                    this.name,
                    bower.name
                    );
        }
    }

    public void bowBack(Friend bower){
        System.out.format(
                "%s: %s has bowed back to me%n",
                this.name,
                bower.name
        );
    }
// Starvation
// Live lock
    public static void main(String[] args) {
        Friend alphonse = new Friend("Alphonse");
        Friend gaston = new Friend("Gaston");

        new Thread(()-> alphonse.bow(gaston)).start();

        new Thread(()-> gaston.bow(alphonse)).start();
    }
}
