package evotek.edu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BatchJob {

  public static void main(String[] args) {
    ExecutorService es = Executors.newFixedThreadPool(5);

    for (int i = 0; i <10; i++){
      es.execute(new Worker(Integer.valueOf(i).toString()));

    }
    es.shutdown();
    // Khi chạy đến i = 4 sẽ dừng lại đợi

//    for (int i = 0; i <10; i++){
//      Worker worker = new Worker(Integer.valueOf(i).toString());
//      Thread thread = new Thread(worker);
//      thread.start();
//
//    }

  }

}
