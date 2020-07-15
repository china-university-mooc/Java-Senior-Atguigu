package com.itutry.demo2;

import com.itutry.demo1.Person;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Test;

public class SetTest {

  @Test
  public void test1() {
    Set set = new HashSet();

    set.add(456);
    set.add(123);
    set.add("AA");
    set.add("CC");
    set.add(new Person("Tom", 12));
    set.add(new Person("Tom", 12));
    set.add(129);
    set.add(123);

    Iterator iterator = set.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  @Test
  public void test2() {
    Set set = new LinkedHashSet();

    set.add(456);
    set.add(123);
    set.add("AA");
    set.add("CC");
    set.add(new Person("Tom", 12));
    set.add(new Person("Tom", 12));
    set.add(129);
    set.add(123);

    Iterator iterator = set.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
