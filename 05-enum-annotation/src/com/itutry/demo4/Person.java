package com.itutry.demo4;

import java.util.ArrayList;

/**
 * 哈哈哈
 */
@MyAnnotation(value = "hi")
@MyAnnotation("abc")
//@MyAnnotationList({@MyAnnotation("hi"), @MyAnnotation("abc")})
public class Person {

  //  @MyAnnotation(value = "hi")
  public Person() {

  }
}

class Generic<@MyAnnotation T> {
  public void show() throws @MyAnnotation RuntimeException {
    ArrayList<@MyAnnotation String> list = new ArrayList<>();
    @MyAnnotation int num = (@MyAnnotation int) 10L;
  }
}
