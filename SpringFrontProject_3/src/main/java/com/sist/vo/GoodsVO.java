package com.sist.vo;

import lombok.Getter;
import lombok.Setter;
// 1. ������ ���
// 2. Cookie ó��
// 3. Session ó��
// 4. �α��� ó�� => password ��ȣȭ ��� + ��ȣȭ ���
// 5. Front => VueJS => watch/computed/component/filter
// 6. ȸ������ => ��ȿ�� �˻� 
@Getter 
@Setter
public class GoodsVO {
	private int no,discount,hit,account;
	private String name,sub,price,first_price,delivery,poster;
}
