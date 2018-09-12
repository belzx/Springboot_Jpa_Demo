package com.lizhi.config;

import com.lizhi.bean.Message;
import com.lizhi.repository.MessageRepository;
import com.lizhi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching//开启缓存支持
public class CacheConfig {

}
