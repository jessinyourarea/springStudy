package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class FoodService {
	@Autowired
	private FoodDAO fdao;
	@Autowired
	private CategoryDAO cdao;
	
	public List<CategoryVO> categoryListData()
	{
		return cdao.categoryListData();
	}
	
	public List<FoodVO> foodListData(int cno)
	{
		return fdao.foodListData(cno);
	}

	public FoodVO foodDetailData(int fno) {
		return fdao.foodDetailData(fno);
	}
}	
