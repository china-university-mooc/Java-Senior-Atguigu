package com.itutry.demo1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import org.junit.Test;

public class OptionalTest {

  @Test
  public void test1() {
    var integer = Optional.of(1);
    System.out.println(integer.isPresent());
    System.out.println(integer.isEmpty());

    var a = integer.orElseThrow();
    System.out.println(a);

    var o = Optional.<Integer>ofNullable(null);
    var or = o.or(() -> Optional.of(1));
    System.out.println(or);
  }

  @Test
  public void test2() {
    //错误的形式: 必须要有类型, 可以加上var
//    Consumer<String> con1 = (@Deprecated t) -> System.out.println(t.toUpperCase());
    // 正确的形式: //使用var的好处是在使用lambda表达式时给参数加上注解。
    Consumer<String> con2 = (@Deprecated var t) -> System.out.println(t.toUpperCase());
  }

  @Test
  public void test3() throws IOException, InterruptedException {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test/")).build();
    BodyHandler<String> responseBodyHandler = BodyHandlers.ofString();
    HttpResponse<String> response = client.send(request, responseBodyHandler);
    String body = response.body();
    System.out.println(body);
  }

  @Test
  public void test4() {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test/")).build();
    BodyHandler<String> responseBodyHandler = BodyHandlers.ofString();
    CompletableFuture<HttpResponse<String>> sendAsync = client
        .sendAsync(request, responseBodyHandler);
    sendAsync.thenApply(t -> t.body()).thenAccept(System.out::println);
  }
}
