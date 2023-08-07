package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface DataBoardMapper {
	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
		  + "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
		  + "FROM (SELECT /*+INDEX_DESC(springDataBoard sdb_no_pk)*/no,subject,name,regdate,hit "
		  + "FROM springDataBoard)) "
		  + "WHERE num BETWEEN #{start} AND #{end}")
	public List<DataBoardVO> databoardListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM springDataBoard")
	public int databoardTotalPage();
	
	@SelectKey(keyProperty = "no", resultType=int.class, before=true, statement="SELECT NVL(MAX(no)+1,1) as no FROM springDataBoard ")
	@Insert("INSERT INTO springDataBoard(no,name,subject,content,pwd,filename,filesize,filecount) "
			+ "VALUES(#{no},#{name},#{subject},#{content},#{pwd},#{filename},#{filesize},#{filecount})")
	public void databoardInsert(DataBoardVO vo);
	
	// 상세보기
	@Update("UPDATE springDataBoard SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no,name,subject,content,hit,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,"
		  + "filename,filesize,filecount "
		  + "FROM springDataBoard "
		  + "WHERE no=#{no}")
	public DataBoardVO databoardDetailData(int no);
	// 수정하기
	// 비밀번호 검색 
	// 수정
	@Select("SELECT pwd FROM springDataBoard WHERE no=#{no}")
	public String databoardGetPwd(int no);
	@Update("UPDATE springDataBoard SET "
		  + "name=#{name},subject=#{subject},content=#{content} "
		  + "WHERE no=#{no}")
	public void databoardUpdate(DataBoardVO vo);
	
	// 삭제하기
	@Delete("DELETE from springDataBoard WHERE no=#{no}")
	public void databoardDelete(int no);
	
	
	// 검색어 찾기
	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit "
		  + "FROM springDataBoard "
		  + "WHERE ${fs} LIKE '%'||#{ss}||'%'")
	// $=>컬럼명, 테이블명 #=>일반데이터
	// name,subject,content ==> 따옴표가 붙으면 안됨. 일반 데이터는 '' 따옴표가 붙는다.
	public List<DataBoardVO> dataBoardFindData(Map map);
	
	
}
