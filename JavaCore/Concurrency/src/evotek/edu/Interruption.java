package evotek.edu;

public class Interruption {

  public static void main(String[] args) {
    BankingThread bt = new BankingThread();
    bt.setName("FA");
    bt.start();
  }

}

class BankingThread extends Thread {

  @Override
  public void run() {
    int count = 0;
    while (count++ < 5) {
      try {
        Thread.sleep(2000);
        if (count == 3){
          this.interrupt();
        }
      } catch (InterruptedException e) {
//        e.printStackTrace();
        System.out.println(e.toString());
      }
      System.out.format("Banking Thread %s is running %d \n", this.getName(), count);
    }

  }
}
