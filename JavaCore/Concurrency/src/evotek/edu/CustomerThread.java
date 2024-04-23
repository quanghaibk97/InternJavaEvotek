package evotek.edu;

class CustomerThread extends Thread {

  @Override
  public void run() {
    int count = 0;
    while (count++ < 5) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.format("Customer Thread %s is running %d \n", this.getName(), count);
    }

  }

  public static class ThreadSample {

    public static void main(String[] args) {
      CustomerThread customerThreadA = new CustomerThread();
      customerThreadA.setName("A");
      customerThreadA.start();

      CustomerThread customerThreadB = new CustomerThread();
      customerThreadB.setName("B");
      customerThreadB.start();

      System.out.println(customerThreadB.isAlive());
    }

  }
}
