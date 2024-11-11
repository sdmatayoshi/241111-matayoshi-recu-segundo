package com.eval.__matayoshi_examen;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketController extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
    	String code="123ABC";
        if(message.getPayload().equals(code)) {
        	try {
        		session.sendMessage(new TextMessage("se conecto CORRECTAMENTE"));
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    	else {
    		try {
            	
        		session.sendMessage(new TextMessage("se conecto INCORRECTAMENTE"));
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
    	}
    }
}