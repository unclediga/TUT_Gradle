package org.unclediga.words;

import org.unclediga.IGreeting;

public class HelloSpring implements IGreeting{
	private String msg;

	public String getMsg(){
		return msg;
	} 

	public void setMsg(String _msg){
		this.msg = _msg;
	} 

    public void sayGreeting(){
    	System.out.println("Hello from Spring Farmework!\nMy msg is \" " + msg + " \" ");
   }
}