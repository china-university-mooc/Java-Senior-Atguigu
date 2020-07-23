package com.itutry.demo1;

import java.util.Comparator;
import java.util.function.Consumer;
import org.junit.Test;

/*
Lambda表达式的使用
1. 举例：(o1,o2) -> {return Integer.compare(o1,o2);};
2. 格式：
      -> : lambda操作符 或 箭头操作符
      ->左边：lambda形参列表（其实就是接口中抽象方法的形参列表）
      ->右边：lambda体（其实就是重写的抽象方法的方法体）

3. lambda表达式的使用：（分6中情况）
    总结：
    ->左边：lambda参数列表的参数类型可以省略(类型推断)；如果参数列表只有一个参数，小括号也可以省略
    ->右边：如果lambda体只有一条执行语句，大括号和return可以省略

4. lambda表达式的本质：作为函数式接口的实例

5. 函数式接口：只包含一个抽象方法的接口，可以在其上使用@FunctionalInterface注解标识

6. 函数式接口的匿名实现类都可以用lambda来实现
 */
public class LambdaTest1 {

  // 语法格式一：无参、无返回值
  @Test
  public void test1() {
    Runnable r = new Runnable() {
      @Override
      public void run() {
        System.out.println("我爱北京天安门");
      }
    };
    r.run();

    System.out.println("**********************");

    Runnable r1 = () -> {
      System.out.println("我爱北京故宫");
    };
    r1.run();
  }

  // 语法格式二：有一个参数，但没有返回值
  @Test
  public void test2() {
    Consumer<String> con = new Consumer<String>() {
      @Override
      public void accept(String s) {
        System.out.println(s);
      }
    };
    con.accept("谎言和誓言的区别是什么？");

    System.out.println("*****************************");

    Consumer<String> con1 = (String s) -> {
      System.out.println(s);
    };
    con1.accept("一个是听得人当真了，一个是说的人当真了");
  }

  // 语法格式三：参数类型可以省略，因为可由编译器推断得出，称为"类型推断"
  @Test
  public void test3() {
    Consumer<String> con1 = (String s) -> {
      System.out.println(s);
    };
    con1.accept("一个是听得人当真了，一个是说的人当真了");

    System.out.println("*****************************");

    Consumer<String> con2 = (s) -> {
      System.out.println(s);
    };
    con2.accept("一个是听得人当真了，一个是说的人当真了");
  }

  // 语法格式四：一个参数时，参数的小括号可以省略
  @Test
  public void test4() {
    Consumer<String> con1 = (s) -> {
      System.out.println(s);
    };
    con1.accept("一个是听得人当真了，一个是说的人当真了");

    System.out.println("*****************************");

    Consumer<String> con2 = s -> {
      System.out.println(s);
    };
    con2.accept("一个是听得人当真了，一个是说的人当真了");
  }

  // 语法格式五：有两个或以上参数，多条执行语句，并且有返回值
  @Test
  public void test5() {
    Comparator<Integer> com1 = new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        System.out.println(o1);
        System.out.println(o2);
        return o1.compareTo(o2);
      }
    };
    System.out.println(com1.compare(12, 21));

    System.out.println("*****************************");

    Comparator<Integer> com2 = (o1, o2) -> {
      System.out.println(o1);
      System.out.println(o2);
      return o1.compareTo(o2);
    };
    System.out.println(com2.compare(12, 6));
  }

  // 语法格式六：lambda体只有一条语句时，return和大括号都可以省略
  @Test
  public void test6() {
    Comparator<Integer> com1 = (o1, o2) -> {
      return o1.compareTo(o2);
    };
    System.out.println(com1.compare(12, 6));

    System.out.println("*****************************");

    Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
    System.out.println(com2.compare(12, 21));
  }
}
