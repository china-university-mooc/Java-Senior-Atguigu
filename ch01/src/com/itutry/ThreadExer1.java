package com.itutry;

/**
 * 创建3个窗口卖票，总票数为100
 *
 * @author itutry
 * @create 2020-04-14_23:10
 */
public class ThreadExer1 {

  public static void main(String[] args) {
    final Window w1 = new Window();
    final Window w2 = new Window();
    final Window w3 = new Window();

    w1.setName("窗口1");
    w2.setName("窗口2");
    w3.setName("窗口3");

    w1.start();
    w2.start();
    w3.start();
  }

  private static class Window extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
      while(ticket > 0) {
        System.out.println(getName() + ":卖票,票号为" + ticket);
        ticket--;
      }
    }
  }
}
