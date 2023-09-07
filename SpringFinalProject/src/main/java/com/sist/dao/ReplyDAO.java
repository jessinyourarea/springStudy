package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.manager.*;
import com.sist.mapper.ReplyMapper;
import com.sist.vo.*;
@Repository
public class ReplyDAO {
	@Autowired
	private ReplyMapper mapper;
	
	public List<ReplyVO> replyListData(int fno){
		return mapper.replyListData(fno);
	}
	
	public void replyInsert(ReplyVO vo)
	{
		mapper.replyInsert(vo);
	}
	
	public ReplyVO foodReplyData(int fno)
	{
		return mapper.foodReplyData(fno);
	}
}
