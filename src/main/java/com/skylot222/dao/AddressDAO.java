package com.skylot222.dao;

import java.util.List;

import com.skylot222.dao.GenericDAO;
import com.skylot222.domain.Address;





public interface AddressDAO extends GenericDAO<Address, Integer> {
  
	List<Address> findAll();
	






}


