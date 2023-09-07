package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;

import com.sist.vo.ChefVO;
import com.sist.vo.RecipeVO;
import com.sist.mapper.*;
@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	
	public List<RecipeVO> recipelistData(Map map)
	{
		return mapper.recipelistData(map);
	}
	
	public int recipeRowCount()
	{
		return mapper.recipeRowCount(); 
	}
	
	public  List<ChefVO> chefListData(Map map)
	{
		return mapper.chefListData(map);
	}
	
	public int chefTotalPage()
	{
		return mapper.chefTotalPage();
	}
	
	public ChefVO chefInfoData(String chef)
	{
		return mapper.chefInfoData(chef);
	}
	
	public List<RecipeVO> chefFindData(Map map)
	{
		return mapper.chefFindData(map);
	}
	public int chefFindCount(Map map)
	{
		return mapper.chefFindCount(map);
	}
}
