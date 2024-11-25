package com.project.WebShop_backend.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        registry.addHandler(transactionResponseHandler(), "/responses").setAllowedOrigins("*");
    }

    @Bean
    public TransactionResponseHandler transactionResponseHandler() {
        return new TransactionResponseHandler();
    }
}
