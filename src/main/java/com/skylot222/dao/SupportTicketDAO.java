package com.skylot222.dao;

import java.util.List;

import com.skylot222.dao.GenericDAO;
import com.skylot222.domain.SupportTicket;





public interface SupportTicketDAO extends GenericDAO<SupportTicket, Integer> {
  
	List<SupportTicket> findAll();
	






}


