package com.sist.main4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Sawon {
	private int sabun;
	private String name;
	private String dept;
	private String job;
	private int pay;

	public Sawon() {}
	
	public void print()
	{
		System.out.println("���:"+sabun);
		System.out.println("�̸�:"+name);
		System.out.println("�μ�:"+dept);
		System.out.println("����:"+job);
		System.out.println("����:"+pay);
	}
	public void init()
	{
		System.out.println("========= ��� ���� ==========");
	}
	
	public void destroy()
	{
		System.out.println("��ü �޸� ����....");
	}
	
}
