package com.web.springboot.micro.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.web.springboot.micro.model.entity.Cuenta;

public interface ICuentaDao extends CrudRepository<Cuenta, Integer> {

}
