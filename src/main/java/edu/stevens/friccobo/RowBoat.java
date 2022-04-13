package edu.stevens.friccobo;

import java.util.List;

public class RowBoat {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static class Singer implements Runnable {
        static final List<String> lyrics = List.of(
                "Row, row, row your boat",
                "Gently down the stream",
                "Merrily, merrily, merrily, merrily",
                "Life is but a dream"
        );
        final String ansiColor;
        int i = 0;

        public Singer(String ansiColor) {
            this.ansiColor = ansiColor;
        }

        @Override
        public void run() {
            while(true){
                System.out.println(ansiColor + lyrics.get(i) + ANSI_RESET);
                i = (i + 1) % lyrics.size();
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }



    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Thread thread = new Thread(new Singer(ANSI_RED));
        Thread thread2 = new Thread(new Singer(ANSI_YELLOW));
        Thread thread3 = new Thread(new Singer(ANSI_BLUE));

        Thread pauseThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }
        });
        pauseThread.start();
        pauseThread.join(2000);
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(3000);
        thread2.start();
        Thread.sleep(3000);
        thread3.start();


        while (thread3.isAlive()){
            if(System.currentTimeMillis() - startTime > 10_000 ){
                thread2.interrupt();
                thread3.interrupt();
            }
        }
    }

}
