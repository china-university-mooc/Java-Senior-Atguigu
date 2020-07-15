package com.itutry.demo3;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.junit.Test;

public class TreeMapTest {

  @Test
  public void test1() {
    TreeMap map = new TreeMap();

    Person p1 = new Person("Tom", 23);
    Person p2 = new Person("Jerry", 32);
    Person p3 = new Person("Jack", 20);
    Person p4 = new Person("Rose", 18);

    map.put(p1, 98);
    map.put(p2, 89);
    map.put(p3, 76);
    map.put(p4, 100);

    Set entrySet = map.entrySet();
    Iterator it = entrySet.iterator();
    while (it.hasNext()) {
      Entry entry = (Entry)it.next();
      System.out.println(entry.getKey() + "-->" + entry.getValue());
    }
  }

  @Test
  public void test2() {
    TreeMap map = new TreeMap(new Comparator() {
      @Override
      public int compare(Object o1, Object o2) {
        if (o1 instanceof Person && o2 instanceof Person) {
          Person p1 = (Person) o1;
          Person p2 = (Person) o2;

          return Integer.compare(p1.getAge(), p2.getAge());
        }
        throw new RuntimeException("传入的数据类型不匹配");
      }
    });

    Person p1 = new Person("Tom", 23);
    Person p2 = new Person("Jerry", 32);
    Person p3 = new Person("Jack", 20);
    Person p4 = new Person("Rose", 18);

    map.put(p1, 98);
    map.put(p2, 89);
    map.put(p3, 76);
    map.put(p4, 100);

    Set entrySet = map.entrySet();
    Iterator it = entrySet.iterator();
    while (it.hasNext()) {
      Entry entry = (Entry)it.next();
      System.out.println(entry.getKey() + "-->" + entry.getValue());
    }
  }
}
