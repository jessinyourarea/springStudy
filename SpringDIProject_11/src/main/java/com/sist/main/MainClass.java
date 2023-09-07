package com.sist.main;

import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import java.util.*;
import com.sist.dao.*;
@Component("mc")
public class MainClass {
	@Autowired
	private FoodService service;
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		Scanner scan=new Scanner(System.in);
		
		MainClass mc=(MainClass)app.getBean("mc");
		
		List<CategoryVO> list=mc.service.categoryListData();
		for(CategoryVO vo:list)
		{
			System.out.println(vo.getCno()+"."+vo.getTitle());
		}
		System.out.println("==================");
		System.out.println("ī�װ� ��ȣ ����:");
		int cno=scan.nextInt();
		List<FoodVO> fList=mc.service.foodListData(cno);
		for(FoodVO vo:fList)
		{
			System.out.println(vo.getFno()+" "+vo.getName());
		}
		System.out.println("=========================");
		System.out.println("���� ��ȣ ����:");
		int fno=scan.nextInt();
		FoodVO vo=mc.service.foodDetailData(fno);
		System.out.println("������:"+vo.getName());
		System.out.println("�ּ�:"+vo.getAddress());
		System.out.println("��ȭ��ȣ:"+vo.getPhone());
		System.out.println("�޴�:"+vo.getMenu());
		System.out.println("��������:"+vo.getType());
		System.out.println("����:"+vo.getPrice());
		System.out.println("����:"+vo.getParking());
		System.out.println("�ð�:"+vo.getTime());
		
	}
	
}
