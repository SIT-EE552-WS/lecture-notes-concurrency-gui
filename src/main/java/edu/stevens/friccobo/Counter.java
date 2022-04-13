package edu.stevens.friccobo;

public class Counter {
    public int c = 0;

    public synchronized void inc(){
        c++;
    }

    public void dec(){
        c--;
    }

    synchronized int value(){
        return c;
    }


    public static void main(String[] args) {
        Counter counter = new Counter();

        (new Thread(
                ()->{
                    while(true) {
                        counter.inc();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        )).start();

        (new Thread(
                ()->{
                    while (true) {
                        System.out.println(counter.value());

                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        )).start();
    }
}
