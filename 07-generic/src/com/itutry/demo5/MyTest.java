package com.itutry.demo5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

public class MyTest {

  @Test
  public void test1() {
    String s = null;
    Object o = null;
    o = s;

    String[] arr1 = null;
    Object[] arr2 = null;
    arr2 = arr1;

    List<String> list1 = null;
    List<Object> list2 = null;
//    list2 = list1;
    // list2.add(123);

    show(list1);
    show(list2);
  }

  @Test
  public void test2() {
    List<String> list1 = null;
    List<Object> list2 = null;
    List<?> list = null;
    list = list1;
    list = list2;


  }

  @Test
  public void test3() {
    List<String> list = new ArrayList<>();
    list.add("AA");
    list.add("BB");
    list.add("CC");
    List<?> list1 = list;

//    list1.add("DD");

    list1.add(null);
    Object o = list1.get(0);
    System.out.println(o);
  }

  @Test
  public void test4() {
    List<? extends Person> list1 = null;
    List<? super Person> list2 = null;

    List<Student> list3 = new ArrayList<>();
    List<Person> list4 = new ArrayList<>();
    List<Object> list5 = new ArrayList<>();

    list1 = list3;
    list1 = list4;
//    list1 = list5;

//    list2 = list3;
    list2 = list4;
    list2 = list5;

    Person person = list1.get(0);
//    list1.add(new Person())
    Object object = list2.get(0);
    list2.add(new Person());
    list2.add(new Student());
  }

  public void show(List<?> list) {
    Iterator<?> it = list.iterator();
    while (it.hasNext()) {
      Object o = it.next();
      System.out.println(o);
    }
  }
}
