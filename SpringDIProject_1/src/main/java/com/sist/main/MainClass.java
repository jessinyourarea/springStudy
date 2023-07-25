package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// XML �Ľ� => �����̳ʿ� ���
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		Sawon s1=(Sawon)app.getBean("sa1");
		System.out.println("���:"+s1.getSabun());
		System.out.println("�̸�:"+s1.getName());
		System.out.println("�μ�:"+s1.getDept());
		System.out.println("����:"+s1.getJob());
		System.out.println("����:"+s1.getPay());
		
		/* 
		Sawon s2=(Sawon)app.getBean("sa2");
		
		System.out.println("���:"+s2.getSabun());
		System.out.println("�̸�:"+s2.getName());
		System.out.println("�μ�:"+s2.getDept());
		System.out.println("����:"+s2.getJob());
		System.out.println("����:"+s2.getPay());
		
		Sawon s3=(Sawon)app.getBean("sa3");
		System.out.println("���:"+s3.getSabun());
		System.out.println("�̸�:"+s3.getName());
		System.out.println("�μ�:"+s3.getDept());
		System.out.println("����:"+s3.getJob());
		System.out.println("����:"+s3.getPay());
		*/
		
		System.out.println("===================================");
		Sawon s2=app.getBean("sa1",Sawon.class); // Generics �ڵ�����ȯ �ϴ� ��� .. 
		s2.setSabun(2);
		s2.setName("��û��");
		s2.setDept("�ѹ���");
		s2.setJob("����");
		s2.setPay(4000);
		
		System.out.println("���:"+s1.getSabun());
		System.out.println("�̸�:"+s1.getName());
		System.out.println("�μ�:"+s1.getDept());
		System.out.println("����:"+s1.getJob());
		System.out.println("����:"+s1.getPay());
		System.out.println("s1:"+s1);
		System.out.println("s2:"+s2);
		
	}

}
