package com.itutry.demo6;

import com.itutry.demo4.Person;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.Test;

public class ReflectionTest {

  @Test
  public void test1() throws Exception {
    Class<Person> clazz = Person.class;

    Person person = clazz.newInstance();

    Field id = clazz.getDeclaredField("age");
    id.setAccessible(true);
    id.set(person, 1001);
    int pId = (int) id.get(person);

    System.out.println(pId);
  }

  @Test
  public void test2() throws Exception {
    Class<Person> clazz = Person.class;

    Person person = clazz.newInstance();
    Method show = clazz.getDeclaredMethod("show", String.class);
    show.setAccessible(true);
    Object chn = show.invoke(person, "CHN");
    System.out.println(chn);

    Method showDesc = clazz.getDeclaredMethod("showDesc");
    showDesc.setAccessible(true);
//    Object invoke = showDesc.invoke(Person.class);
    Object invoke = showDesc.invoke(null);
    System.out.println(invoke);
  }

  @Test
  public void test3() throws Exception {
    Class<Person> clazz = Person.class;
    Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class);
    constructor.setAccessible(true);
    Person tom = constructor.newInstance("Tom");
    System.out.println(tom);
  }
}
