package com.xpand.spring.jpa.repository;

import com.xpand.spring.jpa.entity.Coffee;

import org.springframework.data.repository.CrudRepository;

/**
 * @author: wei.wang
 * @Description:
 * @Date 2019/4/9 17:50
 * @Modified
 */
public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
}
