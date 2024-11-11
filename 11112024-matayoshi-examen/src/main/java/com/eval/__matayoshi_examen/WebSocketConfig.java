package com.eval.__matayoshi_examen;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler(), "/ws").setAllowedOrigins("*")
                .addInterceptors(new HttpSessionHandshakeInterceptor());
    }

    public WebSocketHandler webSocketHandler() {
        return new WebSocketController();
    }

    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}