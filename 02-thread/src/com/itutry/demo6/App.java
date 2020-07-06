package com.itutry.demo6;

public class App {

  public static void main(String[] args) {
    Clerk clerk = new Clerk(2);

    for (int i = 0; i < 5; i++) {
      new Thread(() -> clerk.put(new Object()), "生产者" + (i + 1)).start();
    }

    new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        clerk.take();
      }
    }, "消费者").start();
  }
}

class Clerk {
  private Object[] arr;
  private int head = 0;
  private int tail = 0;

  public Clerk(int capacity) {
    arr = new Object[capacity + 1];
  }

  public synchronized void put(Object o) {
    while((tail + 1) % arr.length == head) {
      try {
        System.out.println(Thread.currentThread().getName() + "：wait... ");
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    arr[tail] = o;
    tail = (tail + 1) % arr.length;
    System.out.println(Thread.currentThread().getName() + "：put " + o);
    notifyAll();
  }

  public synchronized Object take() {
    while (head == tail) {
      try {
        System.out.println(Thread.currentThread().getName() + "：wait... ");
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    Object o = arr[head];
    head = (head + 1) % arr.length;
    System.out.println(Thread.currentThread().getName() + "：take " + o);
    notifyAll();
    return o;
  }
}
