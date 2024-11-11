package com.eval.__matayoshi_examen;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/ws")
public class WebSocketServerEndpoint {

    @OnOpen
    public void onOpen(Session session) {
    	try{
    		session.getBasicRemote().sendText("login");
    	}catch (Exception e) {
            e.printStackTrace();
        }
    }
}