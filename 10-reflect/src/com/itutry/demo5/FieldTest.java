package com.itutry.demo5;

import com.itutry.demo4.Person;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.Test;

public class FieldTest {

  @Test
  public void test1() {
    Class<Person> clazz = Person.class;

    Field[] fields = clazz.getFields();
    for (Field f : fields) {
      System.out.println(f);
    }

    System.out.println();

    Field[] fields1 = clazz.getDeclaredFields();
    for(Field f : fields1) {
      System.out.println(f);
    }
  }

  @Test
  public void test2() {
    Class<Person> clazz = Person.class;

    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
      int modifiers = field.getModifiers();
      System.out.print(Modifier.toString(modifiers) + "\t");

      Class<?> type = field.getType();
      System.out.print(type.getName() + "\t");

      String name = field.getName();
      System.out.print(name);

      System.out.println();
    }
  }
}
