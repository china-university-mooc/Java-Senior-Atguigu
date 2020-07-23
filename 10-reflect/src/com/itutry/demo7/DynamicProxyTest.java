package com.itutry.demo7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */

interface Human {

  String getBelief();

  void eat(String food);
}

class HumanUtil {

  public static void method1() {
    System.out.println("通用方法一");
  }

  public static void method2() {
    System.out.println("通用方法二");
  }
}

class SuperMan implements Human {

  @Override
  public String getBelief() {
    return "I believe I can fly!";
  }

  @Override
  public void eat(String food) {
    System.out.println("我喜欢吃" + food);
  }
}

/*
要想实现动态代理，需要解决的问题？
问题一：如何根据加载到内存中的代理类，动态的创建一个代理类以及其对象
问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类的同名方法
 */
class ProxyFactory {

  // 调用此方法，返回一个代理类的对象，解决问题一
  public static Object getProxyInstance(Object obj) { // obj:被代理类的对象

    Class<?> clazz = obj.getClass();
    MyInvocationHandler handler = new MyInvocationHandler();
    handler.bind(obj);
    return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), handler);
  }
}

class MyInvocationHandler implements InvocationHandler {

  private Object target; // 需要使用被代理类的对象进行赋值

  public void bind(Object target) {
    this.target = target;
  }

  // 当我们通过代理类的对象调用方法a时，就会自动的调用如下方法：invoke
  // 将被代理类要执行的方法a的功能声明在invoke中
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    HumanUtil.method1();

    // method：即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
    // obj: 被代理类的对象
    Object returnValue = method.invoke(target, args);
    HumanUtil.method2();
    // 上述方法的返回值就作为当前类中invoke()的返回值
    return returnValue;
  }
}

public class DynamicProxyTest {

  public static void main(String[] args) {
    SuperMan superMan = new SuperMan();
    // proxy: 代理类的对象
    Human proxy = (Human) ProxyFactory.getProxyInstance(superMan);
    // 当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
    String belief = proxy.getBelief();
    System.out.println(belief);
    proxy.eat("四川麻辣烫");

    System.out.println("*********************************");

    NikeClothFactory nikeClothFactory = new NikeClothFactory();
    ClothFactory proxyInstance = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
    proxyInstance.produceCloth();
  }
}
