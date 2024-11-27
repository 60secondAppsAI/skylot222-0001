package com.skylot222.dao;

import java.util.List;

import com.skylot222.dao.GenericDAO;
import com.skylot222.domain.UserRole;





public interface UserRoleDAO extends GenericDAO<UserRole, Integer> {
  
	List<UserRole> findAll();
	






}


