package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.ReplyMapper;
import com.sist.vo.*;
/*
	데이터 저장 => mounted => render() =>  HTML에 데이터를 출력해주는 곳
	
	
	
 */
@Repository
public class ReplyDAO {
	@Autowired
	private ReplyMapper mapper;
	
	public List<ReplyVO> replyListData(int fno)
	{
		return mapper.replyListData(fno);
	}
		
	public void replyInsert(ReplyVO vo)
	{
		mapper.replyInsert(vo);
	}
	
	public void replyDelete(int no)
	{
		mapper.replyDelete(no);
	}
	
	public void replyUpdate(ReplyVO vo)
	{
		mapper.replyUpdate(vo);
	}
}
