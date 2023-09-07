package com.sist.chat;

import javax.websocket.Session;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import java.util.*;
@ServerEndpoint("/chat/chat-ws")
public class ChatManager {
	private static List<Session> users=new ArrayList<Session>();
	// NodeJs => React
	
	
 	@OnOpen
	// ���� ��û�ÿ� ó��
	public void onOpen(Session session)
	{
		users.add(session);
		System.out.println("Ŭ���̾�Ʈ ����...:"+session.getId());
	}
	
	@OnClose
	// ���� ����� ó��
	public void onClose(Session session)
	{
		users.remove(session);
		System.out.println("Ŭ���̾�Ʈ ����...:"+session.getId());
	}
	
	@OnMessage
	// ä��
	public void onMessage(String message, Session session) throws Exception
	{
		System.out.println("���Ÿ޽���: "+message);
		/*Iterator<Session> it=users.iterator();
		System.out.println("���� �ο�:"+users.size());
		while(it.hasNext())
		{
			it.next().getBasicRemote().sendText(message);
			System.out.println(session.getId()+"����");
		}*/
		for(Session s:users)
		{
			s.getBasicRemote().sendText(message);
			System.out.println(s.getId()+"����");
		}
	} 
}
