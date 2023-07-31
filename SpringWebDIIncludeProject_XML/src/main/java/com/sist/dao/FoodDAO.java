package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class FoodDAO {
	@Autowired // ���������κ��� ������ Ŭ������ �ּҰ��� �޴´� (�ڵ�����)
	private FoodMapper mapper;
	
	public List<CategoryVO> foodCategoryData(Map map)
	{
		return mapper.foodCategoryData(map);
	}
	
	public CategoryVO foodCategoryInfoData(int cno)
	{
		return mapper.foodCategoryInfoData(cno);
	}
	
	public List<FoodVO> foodListData(int cno)
	{
		return mapper.foodListData(cno);
	}
	
	/*@Select("SELECT fno,cno,name,score,poster,phone,address,type,time,"
			+ "parking,price,menu "
			+ "FROM food_house "
			+ "WHERE fno=#{fno}") */
	public FoodVO foodDetailData(int fno)
	{
		return mapper.foodDetailData(fno);
	}
}
