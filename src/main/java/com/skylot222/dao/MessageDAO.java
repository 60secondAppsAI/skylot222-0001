package com.skylot222.dao;

import java.util.List;

import com.skylot222.dao.GenericDAO;
import com.skylot222.domain.Message;





public interface MessageDAO extends GenericDAO<Message, Integer> {
  
	List<Message> findAll();
	






}


