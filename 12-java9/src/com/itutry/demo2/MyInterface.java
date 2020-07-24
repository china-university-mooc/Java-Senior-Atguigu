package com.itutry.java.demo2;

public interface MyInterface {

  void methodAbstract();

  static void methodStatic() {
    System.out.println("接口的静态方法");
  }

  default void methodDefault() {
    System.out.println("接口的默认方法");

    methodPrivate();
  }

  private void methodPrivate() {
    System.out.println("接口的私有方法");
  }
}
