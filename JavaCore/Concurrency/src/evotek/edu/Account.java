package evotek.edu;

import java.util.concurrent.TimeUnit;

public class Account {
  private int balance;

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public Account(int balance) {
    this.balance = balance;
  }

  public void withdraw(String name, int money){
    int count = 0;
    while (count++ <5){
      try {
        TimeUnit.MICROSECONDS.sleep(100);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println(name + "withdrawing");
    }
    if (balance > money){
      balance -= money;
      System.out.println(name + " Succeeded " + balance);
    } else {
      System.out.println(name + " not enough money " + balance);
    }
  }
}
