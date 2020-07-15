package com.itutry.demo4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class CollectionsTest {

  @Test
  public void test1() {
    List list = new ArrayList();
    list.add(123);
    list.add(43);
    list.add(765);
    list.add(-97);
    list.add(0);
    list.add(765);
    list.add(765);

    System.out.println(list);

//    Collections.reverse(list);
//    Collections.shuffle(list);
//    Collections.sort(list);
//    Collections.swap(list, 1, 2);

//    System.out.println(list);

    System.out.println(Collections.max(list));
    System.out.println(Collections.frequency(list, 765));
  }

  @Test
  public void test2() {
    List list = new ArrayList();
    list.add(123);
    list.add(43);
    list.add(765);
    list.add(-97);
    list.add(0);
//
//    ArrayList dest = new ArrayList();
//    dest.add(1);
//    dest.add(1);
//    dest.add(1);
//    dest.add(1);
//    dest.add(1);

    List dest = Arrays.asList(new Object[list.size()]);
    System.out.println(dest);

    Collections.copy(dest, list);
    System.out.println(dest);
  }

  @Test
  public void test3() throws InterruptedException {
    List list = new ArrayList();

    List synchronizedList = Collections.synchronizedList(list);
    List unmodifiableList = Collections.unmodifiableList(list);
    unmodifiableList.add(new Object());
  }
}
