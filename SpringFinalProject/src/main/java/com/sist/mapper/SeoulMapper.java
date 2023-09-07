package com.sist.mapper;
import com.sist.vo.*;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface SeoulMapper {
/*
<select id="seoulLocationData" resultType="SeoulVO" parameterType="hashMap">
     SELECT no,poster,title,num 
     FROM (SELECT no,poster,title,rownum as num 
     FROM (SELECT no,poster,title 
     FROM seoul_location ORDER BY no ASC))
     WHERE num BETWEEN #{start} AND #{end}
   </select>
 */
	public List<SeoulVO> seoulListData();
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM ${table_name}")
	public int seoulTotalPage(Map map);
	
}
