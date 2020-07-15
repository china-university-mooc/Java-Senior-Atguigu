package com.itutry.demo2;

import com.itutry.demo1.Person;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;

public class TreeSetTest {

  @Test
  public void test1() {
    Set set = new TreeSet();

//    set.add(456);
//    set.add(123);
//    set.add("AA");
//    set.add("CC");
//    set.add(new Person("Tom", 12));
//    set.add(new Person("Tom", 12));
//    set.add(129);
//    set.add(123);

//    set.add(34);
//    set.add(-34);
//    set.add(43);
//    set.add(11);
//    set.add(8);

    set.add(new Person("Tom", 12));
    set.add(new Person("Jerry", 32));
    set.add(new Person("Jim", 2));
    set.add(new Person("Mike", 65));
    set.add(new Person("Jack", 33));
    set.add(new Person("Jack", 56));

    Iterator iterator = set.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  @Test
  public void test2() {
    Set set = new TreeSet(new Comparator() {
      @Override
      public int compare(Object o1, Object o2) {
        if (o1 instanceof Person && o2 instanceof Person) {
          Person p1 = (Person) o1;
          Person p2 = (Person) o2;
          return Integer.compare(p1.getAge(), p2.getAge());
        } else {
          throw new RuntimeException("传入的数据类型不一致");
        }
      }
    });

    set.add(new Person("Tom", 12));
    set.add(new Person("Jerry", 32));
    set.add(new Person("Jim", 2));
    set.add(new Person("Mike", 65));
    set.add(new Person("Jack", 33));
    set.add(new Person("Jack", 56));

    Iterator iterator = set.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
