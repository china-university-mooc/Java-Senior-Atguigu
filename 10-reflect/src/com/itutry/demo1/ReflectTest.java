package com.itutry.demo1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.Test;

public class ReflectTest {

  @Test
  public void test1() {
    Person p = new Person("Tom", 12);

    p.age = 10;
    System.out.println(p.toString());

    p.show();
  }

  @Test
  public void test2() throws Exception {
    Class clazz = Person.class;

    Constructor constructor = clazz.getConstructor(String.class, int.class);
    Object obj = constructor.newInstance("Tom", 12);
    Person p = (Person) obj;
    System.out.println(p.toString());

    Field age = clazz.getDeclaredField("age");
    age.set(p, 10);
    System.out.println(p.toString());

    Method show = clazz.getDeclaredMethod("show");
    show.invoke(p);

    System.out.println("**************************");
    Constructor cons1 = clazz.getDeclaredConstructor(String.class);
    cons1.setAccessible(true);
    Person p2 = (Person) cons1.newInstance("Jerry");
    System.out.println(p2);

    Field name = clazz.getDeclaredField("name");
    name.setAccessible(true);
    name.set(p2, "HanMeimei");
    System.out.println(p2);

    Method showNation = clazz.getDeclaredMethod("showNation", String.class);
    showNation.setAccessible(true);
    String nation = (String) showNation.invoke(p2, "中国");
    System.out.println(nation);
  }

  @Test
  public void test3() throws ClassNotFoundException {
    // 方式一：调用运行时类的属性：.class
    Class class1 = Person.class;
    System.out.println(class1);

    // 方式二：通过运行时类的对象，调用getClass
    Person p = new Person();
    Class class2 = p.getClass();
    System.out.println(class2);

    // 方式三：调用Class的静态方法：forName(String classPath)
    Class class3 = Class.forName("com.itutry.demo1.Person");
    System.out.println(class3);

    System.out.println(class1 == class2);
    System.out.println(class1 == class3);

    // 方式四：使用类的加载器：ClassLoader
    ClassLoader classLoader = ReflectTest.class.getClassLoader();
    Class class4 = classLoader.loadClass("com.itutry.demo1.Person");
    System.out.println(class4);
    System.out.println(class1 == class4);
  }
}
