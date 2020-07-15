package com.itutry.demo3;

public class Person implements Comparable {

  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Person() {
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

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }

//  @Override
//  public boolean equals(Object o) {
//    System.out.println("Person equals()...");
//    if (this == o) {
//      return true;
//    }
//    if (o == null || getClass() != o.getClass()) {
//      return false;
//    }
//    Person person = (Person) o;
//    return age == person.age &&
//        name.equals(person.name);
//  }
//
//  @Override
//  public int hashCode() {
////    return Objects.hash(name, age);
//    return name.hashCode() + age;
//  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Person person = (Person) o;

    if (age != person.age) {
      return false;
    }
    return name.equals(person.name);
  }

  @Override
  public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + age;
    return result;
  }

  @Override
  public int compareTo(Object o) {
    if (o instanceof Person) {
      Person p = (Person) o;
      int result = - name.compareTo(p.name);
      if (result == 0) {
        return Integer.compare(age, p.age);
      } else {
        return result;
      }
    } else {
      new RuntimeException("输入的类型不匹配");
    }
    return 0;
  }
}
