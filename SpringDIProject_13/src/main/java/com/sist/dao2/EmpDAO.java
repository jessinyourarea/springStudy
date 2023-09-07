package com.sist.dao2;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper2.*;
import com.sist.vo.EmpVO;

@Repository
public class EmpDAO {
	@Autowired
	private EmpDeptMapper mapper;
	
	public List<EmpVO> empDeptListData()
	{
		return mapper.empDeptListData();
	}
	
	public EmpVO empDeptDetailData(int empno)
	{
		return mapper.empDeptDetailData(empno);
	}
}
