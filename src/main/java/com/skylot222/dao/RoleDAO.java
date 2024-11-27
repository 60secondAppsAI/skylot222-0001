package com.skylot222.dao;

import java.util.List;

import com.skylot222.dao.GenericDAO;
import com.skylot222.domain.Role;





public interface RoleDAO extends GenericDAO<Role, Integer> {
  
	List<Role> findAll();
	






}


