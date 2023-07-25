package com.sist.main3;
import java.util.*;
public class ApplicationContext {
	private Map map=new HashMap(); // Ŭ���� ����
	public ApplicationContext()
	{
		map.put("a", new A());
		map.put("b", new B());
		map.put("c", new C());
		map.put("d", new D());
	}
	
	// Ŭ���� �������� ��� ���� => �����̳� / Factory Pattern 
	// ��ü ã��
	public Object getBean(String key)
	{
		return map.get(key);
	}
	
	/*
		Spring => Ŭ���� ����(�����̳�)
		1. ��ü�� �����ֱ� ���� (���� ~ �Ҹ�)
		2. ��ü ã�� (getBean())
		3. DL/ DI
		   D Lookup => ��üã��
		   D Injection => ����
		     setter DI
		     constructor
		     method
		     
	
	
	 */
}
