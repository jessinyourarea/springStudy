package com.sist.main4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 	�����̳� (�������� �ַ� �ϴ� ����)
 	  => �����ڰ� ����� Ŭ���� (�Ѱ��� ��� ����: ������Ʈ),
 	     ������Ʈ �������� �����ϴ� ����(�����̳�)
 	     JButton, JTextField ..(������Ʈ)
 	     ----------------------------- JFrame(�����̳�)
 	�����̳��� ����
 	 1) ��ü ����(������Ʈ) ==> new (##new����ϴ� ���: VOȣ���-��������� ���������̱� ����)
 	 2) ��ü�� ���� �ʱ�ȭ 
 	 3) ������� �ʴ� ��ü �Ҹ��ϴ� ����
 	 --------------------------=> ��ü�� �����ֱ�
 	 => �ٽ� ��ɿ��� �����ؼ� ����
 	 
 	 ���������� �����ϴ� �����̳� 
 	 --------------------
 	    BeanFactory  ======> �⺻core����(DI)
 	       | 
 ***   ApplicationContext  (Application) ==> core(DI), AOP
 	       | - AnnotationConfigApplicationContext
 	           ----------------------------------
 	          Spring 5�� �ٽ�: XML�� ������� �ʰ� �����ϰ� �ڹٸ� �̿�
 	             
 	  WebApplicationContext (MVC) ==> core(DI),AOP,MVC
 	 
 */
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		// ClassPathXmlApplicationContext : XML�� �Ľ�(XML�� ��ϵ� Ŭ������ �о��)
		// classpath: src/main/java
		
		A a=(A)app.getBean("a");
		a.display();
	}
}
