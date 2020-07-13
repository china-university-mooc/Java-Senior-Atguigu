package com.itutry.demo4;

import java.lang.annotation.Annotation;

public class App {

  public static void main(String[] args) {
    Person person = new Person();
    Annotation[] annotations = Student.class.getAnnotations();

    for (int i = 0; i < annotations.length; i++) {
      System.out.println(annotations[i]);
    }
  }
}
