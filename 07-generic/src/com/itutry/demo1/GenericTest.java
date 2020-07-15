package com.itutry.demo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.Test;

public class GenericTest {

  @Test
  public void test1() {
    List list = new ArrayList();

    list.add(78);
    list.add(76);
    list.add(89);
    list.add(88);

    list.add("Tom");

    for(Object s : list) {
      int score = (int) s;
      System.out.println(score);
    }
  }

  @Test
  public void test2() {
    ArrayList<Integer> list = new ArrayList<>();

    list.add(78);
    list.add(76);
    list.add(89);
    list.add(88);

//    list.add("Tom");

//    for(Integer score : list) {
//      System.out.println(score);
//    }

    Iterator<Integer> it = list.iterator();
    while (it.hasNext()) {
      Integer score = it.next();
      System.out.println(score);
    }
  }

  @Test
  public void test3() {
    Map<String, Integer> map = new HashMap<String, Integer>();

    map.put("Tom", 87);
    map.put("Jerry", 60);
    map.put("Rose", 70);

    Set<Entry<String, Integer>> entrySet= map.entrySet();
    Iterator<Entry<String, Integer>> it = entrySet.iterator();
    while (it.hasNext()) {
      Entry<String, Integer> entry = it.next();
      String key = entry.getKey();
      Integer value = entry.getValue();
      System.out.println(key + " --> " + value);
    }
  }
}
