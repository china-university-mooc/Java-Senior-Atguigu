package com.itutry.exer2;

import java.util.HashSet;
import org.junit.Test;

public class myTest {

  @Test
  public void test() {
    HashSet set = new HashSet();

    Person p1 = new Person(1001, "AA");
    Person p2 = new Person(1002, "BB");

    set.add(p1);
    set.add(p2);
    System.out.println(set);

    p1.setName("CC");
    set.remove(p1);
    System.out.println(set);

    set.add(new Person(1001, "CC"));
    System.out.println(set);

    set.add(new Person(1001, "AA"));
    System.out.println(set);
  }
}
