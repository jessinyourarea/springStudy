package com.sist.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.GoodsVO;

public interface GoodsService {

		public List<GoodsVO> goodsListData(Map map);
		// 인라인뷰 => Top-N : 포트폴리오 => 인라인뷰를 이용한 페이징 기법 사용

		// 상세보기 => Session (장바구니)
		
		public GoodsVO goodsDetailData(int no);
		
		public int goodsTotalPage();
		
}
