package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.RecipeVO;
public interface RecipeMapper {
	// ¸ñ·Ï
	@Select("SELECT no,poster,title,chef,num "
		  + "FROM (SELECT no,poster,title,chef,rownum as num "
		  + "FROM (SELECT no,poster,title,chef "
		  + "FROM recipe ORDER BY no ASC)) "
		  + "WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe")
	public int recipeTotalPage();
	
}
