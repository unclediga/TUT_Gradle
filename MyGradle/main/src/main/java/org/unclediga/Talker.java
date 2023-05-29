package org.unclediga;

import org.unclediga.words.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
 
public class Talker{
  public static void main(String args[]){
    IGreeting w = new Hello();
    w.sayGreeting();
    new Hey().sayGreeting();     
    new GoodDay().sayGreeting();

    ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
    IGreeting hs = (IGreeting) context.getBean("hellospring");
    hs.sayGreeting();

  }
}

