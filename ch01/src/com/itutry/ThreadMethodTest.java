package com.itutry;

/**
 * @author itutry
 * @create 2020-04-14_22:57
 */
public class ThreadMethodTest {

  public static void main(String[] args) throws InterruptedException {
    final MyThread thread = new MyThread();
    thread.setName("线程1");
    thread.start();
//    thread.join();
    Thread.currentThread().setName("主线程");
    for (int i = 0; i < 100; i++) {
      if (i % 2 != 0) {
        System.out.println(Thread.currentThread().getName() + ": i=" + i);
        Thread.sleep(1);
      }
    }
    System.out.println(thread.isAlive());
  }

  private static class MyThread extends Thread {

    @Override
    public void run() {
      for (int i = 0; i < 100; i++) {
        if (i % 2 == 0) {
          System.out.println(Thread.currentThread().getName() + ": i=" + i);
        }

//        if (i % 10 == 0) {
//          yield();
//        }
//        if (i % 10 == 9) {
//          stop();
//        }
      }
    }
  }
}
