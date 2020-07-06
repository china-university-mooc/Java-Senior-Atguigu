package com.itutry.demo7;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class App {

  public static void main(String[] args) {
    Callable<Integer> callable = () -> {
      int sum = 0;
      for (int i = 0; i <= 100; i++) {
        if (i % 2 == 0) {
          sum += i;
        }
      }
      return sum;
    };
    FutureTask<Integer> futureTask = new FutureTask<>(callable);
    new Thread(futureTask).start();

    Integer result = null;
    try {
      result = futureTask.get();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    System.out.println(result);
  }
}
