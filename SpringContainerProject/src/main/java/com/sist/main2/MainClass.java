package com.sist.main2;

public class MainClass {
	public static void main(String[] args) {
		Hello hello=new HelloImp();
		String msg=hello.sayHello("��û��");
		System.out.println(msg);
	}
}
