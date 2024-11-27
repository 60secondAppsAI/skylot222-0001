package com.skylot222.dao;

import java.util.List;

import com.skylot222.dao.GenericDAO;
import com.skylot222.domain.Shipment;





public interface ShipmentDAO extends GenericDAO<Shipment, Integer> {
  
	List<Shipment> findAll();
	






}


