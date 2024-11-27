package com.skylot222.dao;

import java.util.List;

import com.skylot222.dao.GenericDAO;
import com.skylot222.domain.Notification;





public interface NotificationDAO extends GenericDAO<Notification, Integer> {
  
	List<Notification> findAll();
	






}


