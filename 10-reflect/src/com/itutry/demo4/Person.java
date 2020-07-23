package com.itutry.demo4;

import com.sun.org.apache.xerces.internal.dom.AbortException;

@MyAnnotation("hi")
public class Person extends Creature<String> implements Comparable<Person>, MyInterface {

  private String name;
  int age;
  public int id;

  public Person() {
  }

  @MyAnnotation(value = "abc")
  private Person(String name) {
    this.name = name;
  }

  Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @MyAnnotation
  private String show(String nation) throws NullPointerException, AbortException {
    System.out.println("我的国籍是：" + nation);
    return nation;
  }

  public final String display(String interests, int age) {
    return interests + age;
  }

  @Override
  public void info() {
    System.out.println("我是一个人");
  }

  @Override
  public int compareTo(Person o) {
    return 0;
  }

  private static void showDesc() {
    System.out.println("我是一个可爱的人");
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", id=" + id +
        '}';
  }
}
