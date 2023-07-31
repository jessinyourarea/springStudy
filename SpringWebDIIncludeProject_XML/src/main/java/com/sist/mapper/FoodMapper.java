package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
	// ���� ������ �̿��ϴ� ���
	@Select("<script>"
			+ "SELECT cno,poster,title "
			+ "FROM food_category "
			+ "WHERE "
			+ "<if test=\"cno==1\">"
			+ "cno BETWEEN 1 AND 12 "
			+ "</if>"
			+ "<if test=\"cno==2\">"
			+ "cno BETWEEN 13 AND 18 "
			+ "</if>"
			+ "<if test=\"cno==3\">"
			+ "cno BETWEEN 19 AND 30 "
			+ "</if> "
			+ "ORDER BY cno ASC "
			+ "</script>")
	public List<CategoryVO> foodCategoryData(Map map);
	
	// ī�װ� ���� �б�
	@Select("SELECT title,subject "
			+ "FROM food_category "
			+ "WHERE cno=#{cno}")
	public CategoryVO foodCategoryInfoData(int cno);
	
	// ī�װ��� ���� ���� �б�
	@Select("SELECT fno,cno,name,poster,address,score,type,phone "
			+ "FROM food_house "
			+ "WHERE cno=#{cno}")
	public List<FoodVO> foodListData(int cno);
	
	// ������ �󼼺���
	@Select("SELECT fno,cno,name,score,poster,phone,address,type,time,"
			+ "parking,price,menu "
			+ "FROM food_house "
			+ "WHERE fno=#{fno}")
	public FoodVO foodDetailData(int fno);
	
	/*
	 	Mapper������ �ݵ�� �Ű����� 1���� ������ �� ���ִ�
	 	 => �����͸� ���� ÷���� �ÿ��� VO Ȥ�� Map
	 	 => �����Ͱ� VO�� �ִ� �����͸� VO ÷��
	 	 => VO�� ���� ���� ÷�νÿ��� Map
	 	 => ���� ������ �̿��� ������ ������ MAP!
	 	 
	 */
	
}
