package com.lizhi.custom.config;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义Specification（自定义Repository实现）
 *
 */
public class CustomerSpecs {
    public static <T> Specification byAuto(final EntityManager entityManager, final T example) {

        final Class<T> type = (Class<T>) example.getClass();//得到泛型的类型

        //Specification接口中只定义了如下一个方法：
        //我们只需要重写这个方法即可，相关知识请自行查阅JPA Criteria查询
        return new Specification() {

            /**
             * 生成对象
             * string 的根据字段like查询
             * 其他都是equal
             * @param root
             * @param criteriaQuery
             * @param criteriaBuilder
             * @return
             */
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //predicates 用来保存查询条件
                List<Predicate> predicates = new ArrayList<>();

                //将类型封装到predicate中
                EntityType<T> entity = entityManager.getMetamodel().entity(type);
                for (Attribute<T, ?> attr : entity.getDeclaredAttributes()) {
                    Object value = getValue(example, attr);
                    if (value != null) {
                        if (attr.getJavaType() == String.class) {
                            if (!StringUtils.isEmpty(value)) {//如果属性值不为空
                                predicates.add(criteriaBuilder.like(root.get(attribute(entity, attr.getName(), String.class)), pattren((String) value)));
                            }
                        } else {
                            predicates.add(criteriaBuilder.equal(root.get(attribute(entity, attr.getName(), value.getClass())), value));
                        }
                    }
                }
                return null;
            }

            private <T> Object getValue(T example, Attribute<T, ?> attr) {
                return ReflectionUtils.getField((Field) attr.getJavaMember(), example);
            }

            private <E, T> SingularAttribute<T, E> attribute(EntityType<T> entity, String fieldName, Class<E> fieldClass) {
                return (SingularAttribute<T, E>) entity.getSingularAttribute(fieldName, fieldClass);
            }
        };
    }

    static private String pattren(String str) {
        return "%" + str + "%";
    }
}
