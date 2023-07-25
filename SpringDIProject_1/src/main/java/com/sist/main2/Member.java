package com.sist.main2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Member {
	private String id;
	private String name;
	private String address;
	private String phone;
	private String gender;
	
	public void print()
	{
		System.out.println("ID:"+id);
		System.out.println("Name:"+name);
		System.out.println("Address:"+address);
		System.out.println("Phone:"+phone);
		System.out.println("Gender:"+gender);
	}
	
}
