package com.sist.dao;
import java.util.*;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sist.vo.EmpVO;
public class EmpDAO extends SqlSessionDaoSupport{
	/*
	 SQLSessionFactory: parsingµµ ÇÏ°í
	 */
	public List<EmpVO> empDeptListData()
	{
		return getSqlSession().selectList("empDeptListData");
	}
	public EmpVO empDeptDetailData(int empno)
	{
		return getSqlSession().selectOne("empDeptDetailData",empno);
	}
}
