package com.lizhi.Utils;

import com.lizhi.dao.MessageDao;
import com.lizhi.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
public class InitDatabases {

    @Autowired
    MessageDao messageDao;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    private EntityManager entityManager;

    @PostConstruct
    public void initDataBasess(){
       if( !messageDao.tableExist()){
           System.out.println("开始初始化数据库");
           System.out.println("开始建表");
           messageDao.createTable();
       }
    }
}
