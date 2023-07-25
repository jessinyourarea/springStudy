package com.sist.main4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
/*
 	ApplicationContext
 	AnnotationConfigApplicationContext ==> 5버전은 xml 사용없이 java로만 이용하는 방법~~?!?!?!?
 	
 */
public class MainClass {
	private Sawon sa;
	
	public Sawon getSa() {
		return sa;
	}

	public void setSa(Sawon sa) {
		this.sa = sa;
	}

	public static void main(String[] args) {
		//ApplicationContext app=new ClassPathXmlApplicationContext("app4.xml");
		GenericXmlApplicationContext app=new GenericXmlApplicationContext("app4.xml");
		/*Sawon sa=(Sawon)app.getBean("sa1");
		
		// sa.init();
		sa.print();
		// sa.destroy() (X) ==> 메모리 해제 되지 않았기 때문.
		
		app.close(); //==> 메모리 해제~destroy() 불러옴.*/
	}
}
