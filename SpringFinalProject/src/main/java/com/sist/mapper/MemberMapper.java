package com.sist.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.MemberVO;
/*
ID       NOT NULL VARCHAR2(1000) 
PWD      NOT NULL VARCHAR2(1000) 
NAME     NOT NULL VARCHAR2(51)   
GENDER            VARCHAR2(10)   
BIRTHDAY NOT NULL VARCHAR2(30)   
EMAIL             VARCHAR2(100)  
POST     NOT NULL VARCHAR2(10)   
ADDR1    NOT NULL VARCHAR2(200)  
ADDR2             VARCHAR2(200)  
PHONE             VARCHAR2(30)   
CONTENT           CLOB           
ADMIN             CHAR(1)        
REGDATE           DATE    
 */
public interface MemberMapper {
	@Select("SELECT COUNT(*) FROM springMember "
			+ "WHERE id=#{id}")
	public int memberIdCheck(String id);
	
	@Select("SELECT COUNT(*) FROM springMember "
			+ "WHERE email=#{email}")
	public int memberEmailCheck(String email);
	
	@Insert("INSERT INTO springMember VALUES("
		  + "#{id},#{pwd},#{name},#{gender},#{birthday},#{email},#{post},#{addr1},#{addr2},#{phone},#{content},'n',SYSDATE,'ROLE_USER')")
	public void memberJoin(MemberVO vo);
	
	@Select("SELECT pwd,name,role "
		  + "FROM springMember "
		  + "WHERE id=#{id}")
	public MemberVO memberInfoData(String id);
}
