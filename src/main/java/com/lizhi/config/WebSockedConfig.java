package com.lizhi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * 配置websocked
 */
@Configuration
@EnableWebSocketMessageBroker //start websocker  //1开启协议
public class WebSockedConfig extends AbstractWebSocketMessageBrokerConfigurer {


    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) { //2 映射到指定的url
        stompEndpointRegistry.addEndpoint("/endpointWisely").withSockJS(); //3 制定协议
        stompEndpointRegistry.addEndpoint("/endpointChat").withSockJS(); //3 制定协议
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) { //配置消息代理
        registry.enableSimpleBroker("/topic","/queue");//4 广播式配置
    }
}
