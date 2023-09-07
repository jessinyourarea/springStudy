package com.sist.mapper;
import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Select;

public interface RecipeMapper {
	@Select("SELECT no,title,chef,poster,num "
		  + "FROM (SELECT no,title,chef,poster,rownum as num "
		  + "FROM (SELECT /*+INDEX_ASC(recipe recipe_no_pk)*/no,title,chef,poster "
		  + "FROM recipe)) "
		  + "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipelistData(Map map);

	@Select("SELECT COUNT(*) FROM recipe")
	public int recipeRowCount();
	
	@Select("SELECT chef,poster,num "
		  + "FROM (SELECT chef,poster,rownum as num "
		  + "FROM (SELECT chef,poster "
		  + "FROM chef)) "
		  + "WHERE num BETWEEN #{start} AND #{end}")
	public  List<ChefVO> chefListData(Map map);
	
	@Select("SELECT COUNT(*) FROM chef")
	public int chefTotalPage();
	
	@Select("SELECT * FROM chef WHERE chef=#{chef}")
	public ChefVO chefInfoData(String chef);
	
	public List<RecipeVO> chefFindData(Map map);
	public int chefFindCount(Map map);
}
