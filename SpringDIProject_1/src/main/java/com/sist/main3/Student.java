package com.sist.main3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Student {
	private int hakbun;
	private String name;
	private int kor,eng,math;
	
	public void print()
	{
		System.out.println("�й�:"+hakbun);
		System.out.println("�̸�:"+name);
		System.out.println("����:"+kor);
		System.out.println("����:"+eng);
		System.out.println("����:"+math);
		System.out.println("����:"+(kor+eng+math));
		System.out.printf("���:%.2f\n",(kor+eng+math)/3.0);
		
	}
}
