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


        registry.addHandler(successSocket(), "/success").setAllowedOrigins("*");
        registry.addHandler(failedSocket(), "/failed").setAllowedOrigins("*");
        registry.addHandler(errorSocket(), "/error").setAllowedOrigins("*");
    }



    @Bean
    public SuccessSocket successSocket() {
        return new SuccessSocket();
    }

    @Bean
    public ErrorSocket errorSocket(){return new ErrorSocket();}

    @Bean
    public FailedSocket failedSocket(){return new FailedSocket();}

}
