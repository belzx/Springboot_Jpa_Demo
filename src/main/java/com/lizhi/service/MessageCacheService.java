package com.lizhi.service;

import com.lizhi.bean.Message;
import com.lizhi.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 缓存
 * 如果想要切换缓存技术  只需要更改包就行
 * 依赖encache包
 * 或者其他
 */
@Service
public class MessageCacheService {

    @Autowired
    RedisService redisService;

    @Autowired
    MessageService messageService;

    @Autowired
    MessageRepository messageRepository;

    @CachePut(value = "message",key = "#message.id")
    public void save(Message message){
        Message save = messageRepository.save(message);
        System.out.println("为"+save.getIp()+"做出了缓存");
    }

    @CacheEvict(value = "message")
    public void remove(int id){
         messageRepository.deleteById(id);
        System.out.println("删除了缓存");
    }

    @Cacheable(value = "message",key = "'#id'")
    public void find(int id){
        Message one = messageRepository.findOneById(id);
        System.out.println("为"+one+"做出了缓存");
    }

    //redis 乱码
    public void redisSetTest(){
        redisService.set("123","test");
    }

    public String redisGetTest(){
       return redisService.get("123");
    }

}
