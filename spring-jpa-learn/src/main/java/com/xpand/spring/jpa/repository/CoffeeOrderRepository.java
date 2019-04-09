package com.xpand.spring.jpa.repository;

import com.xpand.spring.jpa.entity.CoffeeOrder;

import org.springframework.data.repository.CrudRepository;

/**
 * @author: wei.wang
 * @Description:
 * @Date 2019/4/9 17:49
 * @Modified
 */
public interface CoffeeOrderRepository extends CrudRepository<CoffeeOrder, Long> {
}
