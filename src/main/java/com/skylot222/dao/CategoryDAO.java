package com.skylot222.dao;

import java.util.List;

import com.skylot222.dao.GenericDAO;
import com.skylot222.domain.Category;





public interface CategoryDAO extends GenericDAO<Category, Integer> {
  
	List<Category> findAll();
	






}


