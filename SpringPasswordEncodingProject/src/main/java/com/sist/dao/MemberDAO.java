package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.MemberMapper;
import com.sist.vo.*;

@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
	
	public void signUp(MemberVO vo)
	{
		mapper.signUp(vo);
	}
	
	public int memberIdCheck(String id)
	{
		return mapper.memberIdCheck(id);
	}
	
	public MemberVO memberLogin(String id)
	{
		return mapper.logIn(id);
	}
	
	/*
	public MemberVO logIn(String id,String pwd)
	{
		MemberVO vo=mapper.logIn(id);
		int count=mapper.memberIdCheck(id);
		if(count==0)
		{
			vo.setMsg("NOID");
		}
		else
		{
			if(pwd.equals(vo.getPwd()))
			{
				vo.setMsg("OK");
			}
			else
			{
				vo.setMsg("NOPWD");
			}
		}
		return vo;
	}*/
}
