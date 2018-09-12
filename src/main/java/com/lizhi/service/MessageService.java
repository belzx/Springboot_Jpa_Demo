package com.lizhi.service;

import com.lizhi.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;


@Service
@Transactional //不写接口了
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    @Autowired
    RedisService redisService;

    //jpa对查询默认开启redonly = true 事务属性

    public void selectNameById(String id){
        messageRepository.findOne(id);
    }

    //制定特定异常回滚
    @Transactional(noRollbackFor = IllegalArgumentException.class)
    public void insert(){
//        xxxx
    }

    public String testRedis() {
        String str = null;
        try {
            str = new String("123".getBytes(),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        redisService.set("lizhixiong","aaa");
        return  redisService.get("lizhixiong");
    }
}
