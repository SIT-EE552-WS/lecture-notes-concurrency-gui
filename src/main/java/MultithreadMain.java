/**
 *
 * Concurrent Programming and User Interfaces
 *     - What are Threads and Processes
 *     - How to create and use Threads
 *     - synchronization
 *     - deadlocks and race conditions
 *     - Introduction to JavaFX
 *
 *
 */






public class MultithreadMain {
  public static void threadPrint(String text){
    System.out.printf("[%s] %s%n",
        Thread.currentThread().getName(),
        text);
  }

  public static void main(String[] args) throws InterruptedException {
    new Thread(()->{
      for( int i = 0; i < 4; i++) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        threadPrint("dog");
      }
    }).start();
    final Thread goat = new Thread(() -> {
      for (int i = 0; i < 4; i++) {
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          System.out.println("We are here!");
          e.printStackTrace();
        }
        threadPrint("goat");
      }
    });
    goat.start();
    threadPrint("cat");
    Thread.sleep(4000);
    goat.interrupt();
  }
}
