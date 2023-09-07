package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;

public interface FoodMapper {
	public List<CategoryVO> foodCategoryListData(Map map);
	
	public CategoryVO foodCategoryInfoData(int cno);
	
	public List<FoodVO> foodListData(int cno);
	
	public FoodVO foodDetailData(int fno);
}
