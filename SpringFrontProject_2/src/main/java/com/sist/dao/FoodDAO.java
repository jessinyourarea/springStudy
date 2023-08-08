package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	public List<FoodLocationVO> foodListData(Map map)
	{
		return mapper.foodListData(map);
	}
	public int foodTotalPage()
	{
		return mapper.foodTotalPage();
	}
	
	public FoodLocationVO foodDetailData(int fno)
	{
		return mapper.foodDetailData(fno);
	}
	public List<FoodLocationVO> foodFindData(Map map){
		return mapper.foodFindData(map);
	}
	public int foodFindTotalPage(String address)
	{
		return mapper.foodFindTotalPage(address);
	}
}
