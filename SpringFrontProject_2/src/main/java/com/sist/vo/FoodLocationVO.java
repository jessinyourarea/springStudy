package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FoodLocationVO {
	private int fno,cno;
	private String name,address,phone,type,price,parking,time,menu,poster;
	private double score;
}
