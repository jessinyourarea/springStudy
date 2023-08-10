package com.sist.vo;

import lombok.Getter;
import lombok.Setter;
// 1. 페이지 기법
// 2. Cookie 처리
// 3. Session 처리
// 4. 로그인 처리 => password 암호화 방법 + 복호화 방법
// 5. Front => VueJS => watch/computed/component/filter
// 6. 회원가입 => 유효성 검사 
@Getter 
@Setter
public class GoodsVO {
	private int no,discount,hit,account;
	private String name,sub,price,first_price,delivery,poster;
}
