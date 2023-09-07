package com.sist.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface MemberMapper {
	@Insert("INSERT INTO springTestMember VALUES("
		  + "#{id},#{pwd},#{name},#{gender},SYSDATE)")
	public void signUp(MemberVO vo);
	
	// ·Î±×ÀÎ
	@Select("SELECT COUNT(*) FROM springTestMember "
		  + "WHERE id=#{id}")
	public int memberIdCheck(String id);
	
	@Select("SELECT pwd,name,gender FROM springTestMember "
		  + "WHERE id=#{id}")
	public MemberVO logIn(String id);
}
