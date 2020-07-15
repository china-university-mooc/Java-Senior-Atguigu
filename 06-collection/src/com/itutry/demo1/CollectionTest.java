package com.itutry.demo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.junit.Test;

public class CollectionTest {

  @Test
  public void test1() {
    Collection coll = new ArrayList();
    coll.add("AA");
    coll.add("BB");
    coll.add(123);
    coll.add(new Date());

    System.out.println(coll.size());

    Collection coll1 = new ArrayList();
    coll1.add(456);
    coll1.add("CC");
    coll.addAll(coll1);

    System.out.println(coll);

    coll.clear();
    System.out.println(coll.isEmpty());
  }

  @Test
  public void test2() {
    Collection coll = new ArrayList();
    coll.add(123);
    coll.add(new Person("Tom", 20));
    coll.add("String");

    System.out.println(coll.contains(new Person("Tom", 20)));

    Collection coll1 = Arrays.asList(123, "String", 8);
    System.out.println(coll.containsAll(coll1));
  }

  @Test
  public void test3() {
    Collection coll = new ArrayList();
    coll.add(123);
    coll.add(456);
    coll.add(new Person("Jerry", 20));
    coll.add(new String("Tom"));
    coll.add(false);

    coll.remove(123);

    coll.remove(new Person("Jerry", 20));
    System.out.println(coll);

    Collection coll1 = Arrays.asList(123, 456, 157);
    coll.removeAll(coll1);
    System.out.println(coll);
  }

  @Test
  public void test4() {
    Collection coll = new ArrayList();
    coll.add(123);
    coll.add(456);
    coll.add(new Person("Jerry", 20));
    coll.add(new String("Tom"));
    coll.add(false);

    Collection coll1 = Arrays.asList(123, 456, 157);
    coll.retainAll(coll1);
    System.out.println(coll);
  }

  @Test
  public void test5() {
    Collection coll = new ArrayList();
    coll.add(123);
    coll.add(456);
    coll.add(new Person("Jerry", 20));
    coll.add(new String("Tom"));
    coll.add(false);

    Collection coll1 = new ArrayList();
    coll1.add(456);
    coll1.add(123);
    coll1.add(new Person("Jerry", 20));
    coll1.add(new String("Tom"));
    coll1.add(false);

    System.out.println(coll.equals(coll1));
    System.out.println(coll.hashCode());
  }

  @Test
  public void test6() {
    Collection coll = new ArrayList();
    coll.add(123);
    coll.add(456);
    coll.add(new Person("Jerry", 20));
    coll.add(new String("Tom"));
    coll.add(false);

    Object[] array = coll.toArray();
    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }

    Collection list = Arrays.asList(array);
    System.out.println(list);

    List ints = Arrays.asList(new int[]{123, 456});
    System.out.println(ints.size());

    ints = Arrays.asList(new Integer[]{123, 456});
    System.out.println(ints.size());
  }
}
