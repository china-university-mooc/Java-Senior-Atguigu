package com.itutry.demo2;

public class App {

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      new Thread(() -> System.out.println(Blank.getInstance())).start();
    }
  }
}

class Blank {

  private static Blank instance = null;

  private Blank() {

  }

  public static Blank getInstance() {
    if (instance == null) {
      synchronized (Blank.class) {
        if (instance == null) {
          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          instance = new Blank();
        }
      }
    }
    return instance;
  }
}
