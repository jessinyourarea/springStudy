package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.sist.vo.SeoulVO;
public interface SeoulMapper {
	@Select(value = "{CALL seoulListData(#{pno,mode=IN,javaType=java.lang.Integer},#{pStart,mode=IN,javaType=java.lang.Integer},#{pEnd,mode=IN,javaType=java.lang.Integer},#{pResult,mode=OUT,jdbcType=CURSOR,resultMap=seoulMap})}")
	@Options(statementType = StatementType.CALLABLE)
	public List<SeoulVO> seoulListData(Map map);
	
	@Select(value = "{CALL seoulTotalPage(#{pno,mode=IN,javaType=java.lang.Integer},#{pTotal,mode=OUT,jdbcType=INTEGER})}")
	@Options(statementType = StatementType.CALLABLE)
	public Integer seoulTotalPage(Map map);
	
	public SeoulVO seoulDetailData(Map map);
	
}
