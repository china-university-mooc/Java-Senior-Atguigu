package com.itutry.exer4;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 请把学生名与考试分数录入到集合中，并按分数显示前三名 成绩学员的名字。
 */
public class App {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Set set = new TreeSet();
    for (int i = 1; ; i++) {
      System.out.println("请输入第" + i + "位学生的姓名(输入q退出)：");
      String name = scanner.next();
      if (name.equals("q")) {
        break;
      }
      System.out.println("请输入第" + i + "位学生的成绩：");
      int score = 0;
      try {
        score = scanner.nextInt();
        set.add(new Student(name, score));
      } catch (InputMismatchException e) {
        System.out.println("您输入的成绩有误,请重新输入");
        i--;
      }
    }

    System.out.println("前三名学生如下：");
    System.out.println("姓名\t成绩");
    int count = 0;
    for (Object o : set) {
      Student s = (Student) o;
      System.out.println(s.getName() + "\t" + s.getScore());
      count++;
      if (count == 3) {
        break;
      }
    }
  }
}

class Student implements Comparable {
  private String name;
  private int score;

  public Student() {
  }

  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", score=" + score +
        '}';
  }

  @Override
  public int compareTo(Object o) {
    if (o instanceof Student) {
      Student s = (Student) o;
      return Integer.compare(s.score, this.score);
    }
    return 0;
  }
}
