package com.itutry.demo1;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;

public class ForeachTest {

  @Test
  public void test1() {
    Collection coll = new ArrayList();
    coll.add(123);
    coll.add(456);
    coll.add(new Person("Jerry", 20));
    coll.add(new String("Tom"));
    coll.add(false);

    for (Object e : coll) {
      System.out.println(e);
    }

    coll.forEach(o -> System.out.println(o));
  }
}
