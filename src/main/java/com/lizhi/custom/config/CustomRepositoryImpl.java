package com.lizhi.custom.config;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

import static com.lizhi.custom.config.CustomerSpecs.byAuto;//导入引入的方法

public class CustomRepositoryImpl<T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements CustomRepository<T,ID> {

    private final EntityManager entityManager;


    public CustomRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager = em;
    }


    @Override
    public Page<T> findByAuto(T example, Pageable pageable) {
        return findAll(byAuto(entityManager,example),pageable);
    }


}
