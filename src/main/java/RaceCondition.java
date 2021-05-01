import java.util.concurrent.atomic.AtomicInteger;

public class RaceCondition {
  public static void main(String[] args) {
    final AtomicInteger i =  new AtomicInteger(10);

    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        MultithreadMain.threadPrint(i.decrementAndGet() + "");

      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        if(i.intValue() % 2 == 0){
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          MultithreadMain.threadPrint(i.incrementAndGet() + "");
        }
      }
    }
    ).start();

  }
}
