package com.itutry.demo1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.junit.Test;

public class IteratorTest {

  @Test
  public void test1() {
    Collection coll = new ArrayList();
    coll.add(123);
    coll.add(456);
    coll.add(new Person("Jerry", 20));
    coll.add(new String("Tom"));
    coll.add(false);

    Iterator iterator = coll.iterator();
//    System.out.println(iterator.next());
//    System.out.println(iterator.next());
//    System.out.println(iterator.next());
//    System.out.println(iterator.next());
//    System.out.println(iterator.next());
//    // NoSuchElementException
//    System.out.println(iterator.next());

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  @Test
  public void test2() {
    Collection coll = new ArrayList();
    coll.add(123);
    coll.add(456);
    coll.add(new Person("Jerry", 20));
    coll.add(new String("Tom"));
    coll.add(false);

    Iterator iterator = coll.iterator();
//    iterator.next();
//    iterator.remove();
//    System.out.println(coll);

    while(iterator.hasNext()) {
      Object next = iterator.next();
      if ("Tom".equals(next)) {
        iterator.remove();
//        coll.remove(next);
      }
    }
    System.out.println(coll);
  }
}
