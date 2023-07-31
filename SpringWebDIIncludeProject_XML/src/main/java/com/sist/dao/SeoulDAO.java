package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;
import com.sist.vo.*;
import java.util.*;

@Repository
public class SeoulDAO {
	@Autowired
	private SeoulMapper mapper;
	
	// location
	/*
	@Select("SELECT no,title,poster,num "
		  + "FROM (SELECT no,title,poster,rownum as num "
		  + "FROM (SELECT no,title,poster "
		  + "FROM seoul_location ORDER BY no ASC)) "
		  + "WHERE num BETWEEN #{start} AND #{end}")
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM seoul_location")
	 */
	public List<SeoulVO> seoulLocationListData(Map map)
	{
		return mapper.seoulLocationListData(map);
	}
	public int seoulLocationTotalPage()
	{
		return mapper.seoulLocationTotalPage();
	}
	
	
	// Nature
	public List<SeoulVO> seoulNatureListData(Map map)
	{
		return mapper.seoulNatureListData(map);
	}
	public int seoulNatureTotalPage()
	{
		return mapper.seoulNatureTotalPage();
	}
	
	// Shop
	public List<SeoulVO> seoulShopListData(Map map)
	{
		return mapper.seoulShopListData(map);
	}
	
	public int seoulShopTotalPage()
	{
		return mapper.seoulShopTotalPage();
	}
	
}
