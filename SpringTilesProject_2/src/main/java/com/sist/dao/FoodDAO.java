package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	public List<CategoryVO> foodCategoryData()
	{
		return mapper.foodCategoryData();
	}
	/*
	public List<FoodVO> foodTop7()
	{
		return mapper.foodTop7();
	}
	public List<SeoulVO> locationTop7()
	{
		return mapper.locationTop7();
	} */
	
	/*@Select("SELECT fno,cno,name,poster,address,score,type,phone "
			+ "FROM food_house "
			+ "WHERE cno=#{cno}")*/
	public List<FoodVO> foodListData(int cno)
	{
		return mapper.foodListData(cno);
	}
	
	public CategoryVO foodCategoryInfoData(int cno)
	{
		return mapper.foodCategoryInfoData(cno);
	}

	public List<FoodVO> foodFindData(Map map)
	{
		return mapper.foodFindData(map);
	}
	public int foodFindTotalPage(String fd)
	{
		return mapper.foodFindTotalPage(fd);
	}
	
}
