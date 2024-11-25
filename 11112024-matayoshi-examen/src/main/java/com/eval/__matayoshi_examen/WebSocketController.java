package com.eval.__matayoshi_examen;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Service
public class WebSocketController extends TextWebSocketHandler {
	List<String> messageHistory = new ArrayList<>();
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
    	String code="123ABC";
    	String msg=message.getPayload();
    	String[] parts = msg.split(":");
    	String email = parts[0]; 
    	String password = parts[1];
    	
    	String msg_conn=(email+" se conectó");
    	messageHistory.add(msg_conn);
        if(password.equals(code)) {
        	try {
        		session.sendMessage(new TextMessage(email+" se conectó CORRECTAMENTE"));
        		msg_conn=msg_conn+" CORRECTAMENTE";
        		 messageHistory.add(msg_conn);
        	} 
        	catch (Exception e) {
        			e.printStackTrace();
        	}
        }
    	else {
    		try {
        		session.sendMessage(new TextMessage(email +" se conectó INCORRECTAMENTE"));
        		msg_conn=msg_conn+" INCORRECTAMENTE";
       		 messageHistory.add(msg_conn);
    		} 
    		catch (Exception e) {
            e.printStackTrace();
    		}
    	}
    }
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);

        for (String previousMessage : messageHistory) {
            session.sendMessage(new TextMessage(previousMessage));
        }
    }
}
