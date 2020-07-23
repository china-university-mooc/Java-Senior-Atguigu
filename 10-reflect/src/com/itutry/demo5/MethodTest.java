package com.itutry.demo5;

import com.itutry.demo4.Person;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import org.junit.Test;

public class MethodTest {

  @Test
  public void test1() {
    Class<Person> clazz = Person.class;

    Method[] methods = clazz.getMethods();
    for (Method m : methods) {
      System.out.println(m);
    }

    System.out.println();

    Method[] methods1 = clazz.getDeclaredMethods();
    for (Method m : methods1) {
      System.out.println(m);
    }
  }

  @Test
  public void test2() {
    Class<Person> clazz = Person.class;
    Method[] methods = clazz.getDeclaredMethods();
    for (Method method : methods) {
      Annotation[] annotations = method.getAnnotations();
      for (Annotation a : annotations) {
        System.out.println(a + " ");
      }

      int modifiers = method.getModifiers();
      System.out.print(Modifier.toString(modifiers) + " ");

      Class<?> returnType = method.getReturnType();
      System.out.print(returnType.getName() + " ");

      String name = method.getName();
      System.out.print(name + " ");

      Parameter[] parameters = method.getParameters();
      System.out.print("(");
      for (int i = 0; i < parameters.length; i++) {
        System.out.print(parameters[i].getType().getName() + " args_" + i);
        if (i != parameters.length -1) {
          System.out.print(", ");
        }
      }
      System.out.print(") ");

      Class<?>[] exceptionTypes = method.getExceptionTypes();
      for (int i = 0; i < exceptionTypes.length; i++) {
        if (i == 0) {
          System.out.print("throws ");
        }
        System.out.print(exceptionTypes[i].getName());
        if (i != exceptionTypes.length - 1) {
          System.out.print(", ");
        }
      }

      System.out.println();
    }
  }
}
