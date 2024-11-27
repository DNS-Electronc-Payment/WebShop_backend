package com.project.WebShop_backend.config;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailedSocket extends TextWebSocketHandler {

    private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
    }
    public void broadcastMessage(String message) throws Exception {
        for (WebSocketSession session : sessions) {
            if (session.isOpen()) { // Proverava da li je sesija otvorena
                session.sendMessage(new TextMessage(message));
            } else {
                sessions.remove(session);
                System.out.println("Session closed, removing from active sessions.");
            }
        }
    }
}
