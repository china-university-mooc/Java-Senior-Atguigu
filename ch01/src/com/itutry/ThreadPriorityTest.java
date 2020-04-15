package com.itutry;

/**
 * @author itutry
 * @create 2020-04-14_23:05
 */
public class ThreadPriorityTest {

  public static void main(String[] args) {
    final Thread t1 = new MyThread();
    final Thread t2 = new MyThread();

    t1.setPriority(Thread.MIN_PRIORITY);
    t2.setPriority(Thread.MAX_PRIORITY);
    t1.start();
    t2.start();
    System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority());
  }

  private static class MyThread extends Thread {

    @Override
    public void run() {
      for (int i = 0; i < 100; i++) {
        if (i % 2 == 0) {
          System.out.println(getName() + ":" + getPriority() + "," + i);
        }
      }
    }
  }
}
