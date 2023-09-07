package com.sist.service;

import java.util.List;
import java.util.Map;


import com.sist.vo.RecipeVO;

public interface RecipeService {
	/*@Select("SELECT no,poster,title,chef,num "
			  + "FROM (SELECT no,poster,title,chef,rownum as num "
			  + "FROM (SELECT no,poster,title,chef,num "
			  + "FROM recipe ORDER BY no ASC)) "
			  + "WHERE num BETWEEN #{start} AND #{end}")*/
	public List<RecipeVO> recipeListData(Map map);
		
	/*@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe")*/
	public int recipeTotalPage();
}
