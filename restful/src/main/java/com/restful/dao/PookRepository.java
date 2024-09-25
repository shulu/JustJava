package com.restful.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restful.entity.Pooks;

@Repository
public interface  PookRepository extends CrudRepository<Pooks, Integer> {

}
