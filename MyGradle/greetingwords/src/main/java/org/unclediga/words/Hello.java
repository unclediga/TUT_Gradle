package org.unclediga.words;

import org.unclediga.IGreeting;

public class Hello implements IGreeting{
   public void sayGreeting(){
       System.out.println("Hello,World!!!");
   }
}