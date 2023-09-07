package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.DataBoardMapper;
import com.sist.vo.DataBoardVO;

@Repository
public class DataBoardDAO {
	@Autowired
	private DataBoardMapper mapper;
	
	public List<DataBoardVO> dataBoardListData(Map map)
	{
		return mapper.dataBoardListData(map);
	}
	
	public int databoardTotalpage()
	{
		return mapper.databoardTotalpage();
	}
	
	public void dataBoardInsert(DataBoardVO vo)
	{
		mapper.dataBoardInsert(vo);
	}
	

	public DataBoardVO databoardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.databoardDetailData(no);
	}
	
	public String databoardUpdate(DataBoardVO vo)
	{
		String result="";
		String db_pwd=mapper.databoardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd()))
		{
			result="yes";
			mapper.databoardUpdate(vo);
		}
		else
		{
			result="no";
		}
		return result;
	}
	
	public String databoardDelete(int no, String pwd)
	{
		String result="";
		String db_pwd=mapper.databoardGetPassword(no);
		if(db_pwd.equals(pwd))
		{
			result="yes";
			mapper.databoardDelete(no);
		}
		else
		{
			result="no";
		}
		return result;
	}
	
	public DataBoardVO databoardFileInfoData(int no)
	{
		return mapper.databoardFileInfoData(no);
	}
	
}
