package com.itutry;

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

    @Override
    public void run() {
      while(ticket > 0) {
        System.out.println(Thread.currentThread().getName() + ":卖票，票号为" + ticket);
        ticket--;
      }
    }
  }
}
