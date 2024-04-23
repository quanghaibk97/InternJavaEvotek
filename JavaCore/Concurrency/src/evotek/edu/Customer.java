package evotek.edu;

import java.util.concurrent.TimeUnit;

public class Customer implements Runnable{
  private String name;
  private Account account;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public synchronized static void print(String name){
    int count = 0;
    while (count++ <5){
      try {
        TimeUnit.MICROSECONDS.sleep(100);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println(name + "printing");
    }
  }

  public Customer(String name, Account account) {
    this.name = name;
    this.account = account;
  }

  @Override
  public void run() {
//    synchronized (account){
//      account.withdraw(name, 50);
//    }
    print(name);

  }
}
