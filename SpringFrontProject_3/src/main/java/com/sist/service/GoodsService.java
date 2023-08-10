package com.sist.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.GoodsVO;

public interface GoodsService {

		public List<GoodsVO> goodsListData(Map map);
		// �ζ��κ� => Top-N : ��Ʈ������ => �ζ��κ並 �̿��� ����¡ ��� ���

		// �󼼺��� => Session (��ٱ���)
		
		public GoodsVO goodsDetailData(int no);
		
		public int goodsTotalPage();
		
}
