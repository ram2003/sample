package com.accenture.dao;

import org.springframework.data.repository.CrudRepository;

import com.accenture.entity.CustomerEntityBean;

public interface CustomerDAO extends CrudRepository<CustomerEntityBean, Integer> {

}
