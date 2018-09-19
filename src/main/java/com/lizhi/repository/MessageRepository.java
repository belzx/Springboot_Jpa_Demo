package com.lizhi.repository;

import com.lizhi.bean.Message;
import com.lizhi.custom.config.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;

@Repository
public interface MessageRepository extends CustomRepository<Message,String>
{
    /**
     * 1： jpa 可以自动化根据方法名称查询 结果
     *
     */
    Message findOneById(Integer id);

    Message deleteById(Integer id);

    List<Message> findFirst10ByNickNameLike(String nickName); //属性的名称必须与bean中的保持一致

    /**
     * 2 根据entity NamedQuery注解查询,在entity中定义
     */

    Message countid(Integer id);


    /**
     * 3 根据@query注解书写查询语句
     */

    /**
     * 注意
     *     hql 不支持 left join on   要改成where 就可以了
     *
     * @return
     */
    @Query(value = "select * from Message M LIMIT 0 , 10", nativeQuery = true)
     List<Message> countAll() ;

    /**
     * @Modifying 配合  @Query 表示 使用upadte
     * @param name
     * @param id
     * @return
     */
    @Modifying
    @Transactional
    @Query("update Message set NICK_NAME = ?1 where id = ?2")
    int setName(String name , Integer id);

//    /**
//     * 使用rest风格的查询
//     * @param id
//     * @return
//     */
//    Message findByIdStartsWith(int id);

}