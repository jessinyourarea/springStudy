package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import com.sist.vo.*;
public interface FoodMapper {
	// ��� 
	@Select("SELECT fno,name,poster,score,num "
		  + "FROM (SELECT fno,name,poster,score,rownum as num "
		  + "FROM (SELECT fno,name,poster,score "
		  + "FROM food_location ORDER BY fno ASC)) "
		  + "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodLocationVO> foodListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM food_location")
	public int foodTotalPage();
	
	// ��
	@Select("SELECT fno,name,poster,score,parking,menu,type,time,phone,address,price "
		  + "FROM food_location "
		  + "WHERE fno=#{fno}")
	public FoodLocationVO foodDetailData(int fno);
	
	// �˻� ==> Vue/React => �ǽð�
	@Select("SELECT fno,name,poster,score,num "
		   + "FROM (SELECT fno,name,poster,score,rownum as num "
		   + "FROM (SELECT fno,name,poster,score "
		   + "FROM food_location WHERE address LIKE '%'||#{address}||'%' ORDER BY fno ASC)) "
		   + "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodLocationVO> foodFindData(Map map);	
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM food_location "
		  + "WHERE address LIKE '%'||#{address}||'%'")
	public int foodFindTotalPage(String address);
	
	
}
