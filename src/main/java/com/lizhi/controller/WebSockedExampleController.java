package com.lizhi.controller;

import com.lizhi.bean.WiselyMessage;
import com.lizhi.bean.WiselyResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * 测试websocked入口
 */
@Controller
public class WebSockedExampleController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    private static Logger logger = LoggerFactory.getLogger(WebSockedExampleController.class);

    /**
     * 广播式发送
     * @param wiselyMessage
     * @return
     * @throws InterruptedException
     */
    @MessageMapping("/web")
    @SendTo("/topic/getResponse")
    public WiselyResponse say(WiselyMessage wiselyMessage) throws InterruptedException {
        Thread.sleep(1000);
        logger.info("name=" + wiselyMessage.getName());
        return new WiselyResponse("name=" + wiselyMessage);
    }

    /**
     * 点对点发送
     * @return
     * @throws InterruptedException
     */
    @MessageMapping("/chat")
    public void say(Principal principal,String msg ) throws InterruptedException {
        logger.info("msg:{} principal name{}",msg,principal.getName());
        if(principal.getName().endsWith("lzx")){
            simpMessagingTemplate.convertAndSendToUser("wisely","/queue/notification",principal.getName()+"-send:"+msg);
        }else{
            simpMessagingTemplate.convertAndSendToUser("lzx","/queue/notification",principal.getName()+"-send:"+msg);
        }
    }
}
