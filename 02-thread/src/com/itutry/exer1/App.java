package com.itutry.exer1;

public class App {

  public static void main(String[] args) {
    Account account = new Account();

    for (int i = 0; i < 2; i++) {
      new Thread(() -> {
        for (int j = 0; j < 3; j++) {
          account.deposit(1000);
        }
      }, "线程" + (i + 1)).start();
    }
  }
}

class Account {
  private double balance;

  public double getBalance() {
    return balance;
  }

  public synchronized void deposit(double amount) {
    if (amount > 0) {
      this.balance += amount;
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(Thread.currentThread().getName() + "：存钱成功，账户余额 " + getBalance());
    }
  }
}
