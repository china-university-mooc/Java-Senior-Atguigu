package com.itutry.demo5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App {

  public static void main(String[] args) {
    Printer printer = new Printer();
    Thread t1 = new Thread(printer::print, "线程1");
    Thread t2 = new Thread(printer::print, "线程2");

    t1.start();
    t2.start();
  }
}

//class Printer {
//  private int num = 1;
//
//  public void print() {
//    while (true) {
//      synchronized (this) {
//        notifyAll();
//
//        if (num <= 100) {
//          System.out.println(Thread.currentThread().getName() + "：" + num);
//          num++;
//
//          try {
//            wait();
//          } catch (InterruptedException e) {
//            e.printStackTrace();
//          }
//        } else {
//          break;
//        }
//      }
//    }
//
//  }
//}

class Printer {
  private int num = 1;
  private Lock lock = new ReentrantLock();
  private Condition c = lock.newCondition();

  public void print() {
    while (true) {
      try {
        lock.lock();
        c.signal();

        if (num <= 100) {
          System.out.println(Thread.currentThread().getName() + "：" + num);
          num++;

          try {
            c.await();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        } else {
          break;
        }
      } finally {
        lock.unlock();
      }
    }

  }
}
