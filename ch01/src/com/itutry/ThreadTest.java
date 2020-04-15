package com.itutry;

/**
 * @author itutry
 * @create 2020-04-14_22:39
 */
public class ThreadTest {

  public static void main(String[] args) {
    final MyThread thread = new MyThread();
//    thread.run(); 不能直接调用run()启动线程
    thread.start();
//    thread.start(); start()只能调用一次
  }

  private static class MyThread extends Thread {

    @Override
    public void run() {
      for (int i = 0; i < 100; i++) {
        if (i % 2 == 0) {
          System.out.println(Thread.currentThread().getName() + ": i=" + i);
        }
      }
    }
  }
}
