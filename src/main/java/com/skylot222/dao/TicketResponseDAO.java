package com.skylot222.dao;

import java.util.List;

import com.skylot222.dao.GenericDAO;
import com.skylot222.domain.TicketResponse;





public interface TicketResponseDAO extends GenericDAO<TicketResponse, Integer> {
  
	List<TicketResponse> findAll();
	






}


