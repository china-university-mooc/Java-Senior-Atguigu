package com.itutry.java.demo2;

public class Impl implements MyInterface {

  @Override
  public void methodAbstract() {

  }

//  @Override
//  public void methodDefault() {
////      MyInterface.super.methodDefault();
//    System.out.println("实现类重写");
//  }

  public static void main(String[] args) {
    MyInterface.methodStatic();

    Impl impl = new Impl();
    impl.methodDefault();
  }
}
