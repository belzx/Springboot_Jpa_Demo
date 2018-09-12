package com.lizhi.controller;

import com.lizhi.bean.Message;
import com.lizhi.repository.MessageRepository;
import com.lizhi.repository.MessageRepositoryByAuto;
import com.lizhi.service.MessageCacheService;
import com.lizhi.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * 测试jpa 入口
 */
@RestController
@RequestMapping("/jpa")
public class JPAController {

    private final static Logger logger = LoggerFactory.getLogger(JPAController.class);

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    MessageRepositoryByAuto messageRepositoryByAuto;

    @Autowired
    MessageCacheService messageCacheService;

    @Autowired
    MessageService messageService;
    @RequestMapping(value = "/{id}",method=RequestMethod.GET)
    public String getAdminInfo(@PathVariable(value = "id") Integer id)
    {
        //详情可参考书
        Message obj = messageRepository.findOneById(id);

        System.out.println(obj);

        System.out.println("1 ：使用jpa方法名查询：" + messageRepository.findFirst10ByNickNameLike("%司%"));

//        System.out.println(messageRepository.findByNickNameLikeAndIdLike("李",id));

        System.out.println("2 ：使用bean方法上面查询：" + messageRepository.countid(2));

        System.out.println("3 ：使用方法上面注解备注查询：" + messageRepository.countAll());

        System.out.println("4 ：双注解使用update：" + messageRepository.setName("0000",1));
        Page<Message> byAuto = messageRepositoryByAuto.findByAuto(new Message(), new PageRequest(0, 10));

        System.out.println("5 ：使用自定义的CustomRepositroy：" );
        byAuto.forEach(System.out::println);


        System.out.println("6 ：测试回滚：" );
        messageService.insert();

        System.out.println("7 ：测试缓存技术：" );
        long star = System.currentTimeMillis();
        messageCacheService.find(12345);
        long star2 = System.currentTimeMillis();
        messageCacheService.find(12345);
        long star3 = System.currentTimeMillis();
        logger.info("第一次查询耗时：{} 使用cache查询 耗时：{}",star2 - star , star3 - star2);

        System.out.println("8 ：测试redis技术：" );
        logger.info( messageService.testRedis());
        messageCacheService.redisSetTest();
        logger.info( messageCacheService.redisGetTest());
        return "";
    }

    @RequestMapping(value = "/a",method=RequestMethod.GET)
    @Transactional //使用申明式事务，前提是要开启事务  通过@EnabeleTransactionalMangement，开启对这个的扫描
    public String getAfo()
    {
        System.out.println(111);
        messageRepository.save(new Message());
        return "123123";
    }
}
