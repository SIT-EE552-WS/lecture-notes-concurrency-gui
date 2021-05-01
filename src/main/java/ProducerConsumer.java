import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {
  public static class SafeList {
    private List<String> stringList = new ArrayList<>();

    synchronized void add(String string){
      stringList.add(string);
    }

    synchronized int size(){
      return stringList.size();
    }

    synchronized void remove(int index){
      stringList.remove(index);
    }

    @Override public String toString(){
      return stringList.toString();
    }
  }
  public static void main(String[] args) {
    SafeList stringList = new SafeList();
    final Thread producer = new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        stringList.add("String " + i);
      }
    });

    final Thread consumer = new Thread(() -> {
      for(int i = 0; i < 11; i++) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        if(stringList.size()>0) {
          System.out.println(stringList);
          stringList.remove(0);
        } else {
          System.out.println("empty");
        }
      }
    });
    producer.start();
    consumer.start();
    System.out.println(stringList);
  }
}
