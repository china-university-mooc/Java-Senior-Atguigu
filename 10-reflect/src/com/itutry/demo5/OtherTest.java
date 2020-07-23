package com.itutry.demo5;

import com.itutry.demo4.Person;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.junit.Test;

public class OtherTest {

  @Test
  public void test1() {
    Class<Person> clazz = Person.class;

    Constructor<?>[] constructors = clazz.getConstructors();
    for (Constructor<?> c : constructors) {
      System.out.println(c);
    }

    System.out.println();
    Constructor<?>[] constructors1 = clazz.getDeclaredConstructors();
    for (Constructor<?> c : constructors1) {
      System.out.println(c);
    }
  }

  @Test
  public void test2() {
    Class<Person> clazz = Person.class;
    Class<? super Person> superclass = clazz.getSuperclass();
    System.out.println(superclass);
    System.out.println("*****");

    // 获取带泛型的父类
    Type genericSuperclass = clazz.getGenericSuperclass();
    System.out.println(genericSuperclass);

    // Type转成ParameterizedType
    ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
    // 获取类型参数
    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
    Type typeArgument = actualTypeArguments[0];
    System.out.println(typeArgument.getTypeName());

    System.out.println(((Class)typeArgument).getName());
  }

  @Test
  public void test3() {
    Class<Person> clazz = Person.class;

    Class<?>[] interfaces = clazz.getInterfaces();
    for (Class<?> c : interfaces) {
      System.out.println(c);
    }
    System.out.println();

    Type[] genericInterfaces = clazz.getGenericInterfaces();
    for (Type t : genericInterfaces) {
      System.out.println(t);
    }
    System.out.println();

    Class<?>[] interfaces1 = clazz.getSuperclass().getInterfaces();
    for (Class<?> c : interfaces1) {
      System.out.println(c);
    }
  }

  @Test
  public void test4() {
    Class<Person> clazz = Person.class;
    Package pck = clazz.getPackage();
    System.out.println(pck);

    Annotation[] annotations = clazz.getAnnotations();
    for (Annotation a : annotations) {
      System.out.println(a);
    }
  }
}
