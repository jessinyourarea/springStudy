package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.dao.*;
@Component("mc")
public class MainClass {
	@Autowired   // ���������� �ڵ����� ��ü �ּҰ��� ã�Ƽ� ����
	@Qualifier("bdao") //��ü�� �������϶�, �ش� ��ü�� �����ؼ� ���
	private Board board;
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		
	}
}
