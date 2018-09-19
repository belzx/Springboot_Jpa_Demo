package com.lizhi.dao;

import com.lizhi.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
public class MessageDao {

    @Autowired
    private EntityManager entityManager;

    public void testSql(){
        Query nativeQuery = entityManager.createNativeQuery("select * from message ");
        List resultList = nativeQuery.getResultList();
        System.out.println(""+resultList);
    }

    public boolean tableExist(){
        Query nativeQuery = entityManager.createNativeQuery(" SHOW TABLES LIKE 'messageTest'");
        List resultList = nativeQuery.getResultList();
        if(resultList ==null || resultList.size() == 0){
            return false;
        }
        return true;
    }

    public void createTable() {
        Query nativeQuery = entityManager.createNativeQuery("CREATE TABLE `messageTest` (\n" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `insert_time` datetime DEFAULT NULL,\n" +
                "  `ip` varchar(255) DEFAULT NULL,\n" +
                "  `nick_name` varchar(255) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8;");
//        nativeQuery.executeUpdate();
        //建表语句    不太会
    }
}
