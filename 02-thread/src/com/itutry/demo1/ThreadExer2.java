package com.itutry.demo1;

/**
 * 创建3个窗口卖票，总票数为100
 *
 * @author itutry
 * @create 2020-04-14_23:15
 */
public class ThreadExer2 {

  public static void main(String[] args) {
    final Window window = new Window();

    new Thread(window, "窗口1").start();
    new Thread(window, "窗口2").start();
    new Thread(window, "窗口3").start();
  }

  private static class Window implements Runnable {

    private int ticket = 100;
    private Object obj = new Object();

    @Override
    public void run() {
      while (true) {
//        synchronized (obj) {
        synchronized (this) {
          if (ticket > 0) {
            try {
              Thread.sleep(100);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":卖票，票号为" + ticket);
            ticket--;
          } else {
            break;
          }
        }
      }
    }
  }
}
