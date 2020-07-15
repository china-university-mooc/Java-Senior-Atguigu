package com.itutry.demo2;

import com.itutry.demo1.Person;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

public class ListTest {

  @Test
  public void test1() {
    List list = new ArrayList();
    list.add(123);
    list.add(456);
    list.add("AA");
    list.add(new Person("Tom", 12));
    list.add(456);
    System.out.println(list);

    list.add(1, "BB");
    System.out.println(list);

    List list1 = Arrays.asList(1, 2, 3);
    list.addAll(1, list1);
    System.out.println(list.size());
    System.out.println(list);

    System.out.println(list.get(0));
  }

  @Test
  public void test2() {
    List list = new ArrayList();
    list.add(123);
    list.add(456);
    list.add("AA");
    list.add(new Person("Tom", 12));
    list.add(456);
    System.out.println(list.indexOf(456));
    System.out.println(list.lastIndexOf(456));

    System.out.println(list.remove(0));
    System.out.println(list);

    System.out.println(list.set(1, "CC"));
    System.out.println(list);

    System.out.println(list.subList(2, 4));
  }

  @Test
  public void test3() {
    List list = new ArrayList();
    list.add(123);
    list.add(456);
    list.add("AA");
    list.add(new Person("Tom", 12));
    list.add(456);

    Iterator it = list.iterator();
    while(it.hasNext()) {
      System.out.println(it.next());
    }
    System.out.println("***************");

    for(Object e : list) {
      System.out.println(e);
    }
    System.out.println("***************");

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }
}
