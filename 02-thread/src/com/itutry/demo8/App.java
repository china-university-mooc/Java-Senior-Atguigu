package com.itutry.demo8;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class App {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    ThreadPoolExecutor executor = (ThreadPoolExecutor) executorService;
    executor.setCorePoolSize(5);
    executorService.execute(() -> {
      for (int i = 0; i <= 100; i++) {
        if (i % 2 == 0) {
          System.out.println(Thread.currentThread().getName() + "：" + i);
        }
      }
    });
    Future<Integer> future = executorService.submit(() -> {
      int sum = 0;
      for (int i = 0; i <= 100; i++) {
        if (i % 2 != 0) {
          sum += i;
        }
      }
      return sum;
    });
    try {
      System.out.println("结果：" + future.get());
    } catch (InterruptedException e) {
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    executorService.shutdown();
  }
}
