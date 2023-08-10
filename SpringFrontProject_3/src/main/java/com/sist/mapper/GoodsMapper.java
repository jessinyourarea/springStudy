package com.sist.mapper;
import java.util.*;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.GoodsVO;

public interface GoodsMapper {
	@Select("SELECT no, goods_name as name, goods_poster as poster, goods_price as price, num "
		  + "FROM (SELECT no, goods_name, goods_poster, goods_price, rownum as num "
		  + "FROM (SELECT no, goods_name, goods_poster, goods_price "
		  + "FROM goods_all ORDER BY no ASC)) "
		  + "WHERE num BETWEEN #{start} AND #{end}")
	public List<GoodsVO> goodsListData(Map map);
	// �ζ��κ� => Top-N : ��Ʈ������ => �ζ��κ並 �̿��� ����¡ ��� ���

	@Select("SELECT CEIL(COUNT(*)/12.0) from goods_all ")
	public int goodsTotalPage();
	
	// �󼼺��� => Session (��ٱ���)
	@Update("UPDATE goods_all SET "
		  + "hit=hit+1 "
		  + "WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no,goods_name as name, goods_sub as sub, goods_price as price, goods_discount as discount,"
		  + "goods_first_price as first_price, goods_delivery as delivery, goods_poster as poster, hit, account "
		  + "FROM goods_all "
		  + "WHERE no=#{no}")
	public GoodsVO goodsDetailData(int no);
}
