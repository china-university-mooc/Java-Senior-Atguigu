package com.itutry.demo3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.Test;

public class MapTest {

  @Test
  public void test1() {
//    Map map = new HashMap();
    Map map = new Hashtable();

    map.put(null, null);
  }

  @Test
  public void test2() {
//    Map map = new HashMap();
    Map map = new LinkedHashMap();

    map.put(123, "AA");
    map.put(345, "BB");
    map.put(12, "CC");

    System.out.println(map);
  }

  @Test
  public void test3() {
    Map map = new HashMap();

    map.put("AA", 123);
    map.put(45, 123);
    map.put("BB", 56);
    map.put("AA", 87);

    System.out.println(map);

    Map map1 = new HashMap();
    map1.put("CC", 123);
    map1.put("DD", 123);
    map.putAll(map1);
    System.out.println(map);

    System.out.println(map.remove("CC"));
    System.out.println(map);

    map.clear();
    System.out.println(map);
  }

  @Test
  public void test4() {
    Map map = new HashMap();

    map.put("AA", 123);
    map.put(45, 123);
    map.put("BB", 56);

    System.out.println(map.get(455));
    System.out.println(map.containsKey("AA"));
    System.out.println(map.containsValue(56));
    System.out.println(map.size());
    System.out.println(map.isEmpty());

    Map map1 = new HashMap();
    map1.put("AA", 123);
    map1.put("BB", 56);
    map1.put(45, 123);
    System.out.println(map.equals(map1));
  }

  @Test
  public void test5() {
    Map map = new HashMap();

    map.put("AA", 123);
    map.put(45, 123);
    map.put("BB", 56);

    Set set = map.keySet();
    Iterator it = set.iterator();
    while(it.hasNext()) {
      System.out.println(it.next());
    }

    System.out.println("*******************");
    Collection values = map.values();
    for(Object o : values) {
      System.out.println(o);
    }

    System.out.println("*******************");
    Set entrySet = map.entrySet();
    Iterator it1 = entrySet.iterator();
    while(it1.hasNext()) {
      Object next = it1.next();
      Entry entry = (Entry) next;
      System.out.println(entry.getKey() + "-->" + entry.getValue());
    }
  }
}
