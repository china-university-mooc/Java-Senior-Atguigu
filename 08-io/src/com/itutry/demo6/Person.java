package com.itutry.demo6;

import java.io.Serializable;

public class Person implements Serializable {

  private static final long serialVersionUID = 2379798L;

  private static String name;
  private transient int age;
  private int id;
  private Account acc;

  public Person(String name, int age, int id, Account acc) {
    this.name = name;
    this.age = age;
    this.id = id;
    this.acc = acc;
  }

  public Person(String name, int age, int id) {
    this.name = name;
    this.age = age;
    this.id = id;
  }

  public Person() {
  }

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", id=" + id +
        ", acc=" + acc +
        '}';
  }
}

class Account implements Serializable {

  private static final long serialVersionUID = 7977897898L;

  private double balance;

  public Account(double balance) {
    this.balance = balance;
  }

  public Account() {
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "Account{" +
        "balance=" + balance +
        '}';
  }
}
