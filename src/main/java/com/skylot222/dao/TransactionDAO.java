package com.skylot222.dao;

import java.util.List;

import com.skylot222.dao.GenericDAO;
import com.skylot222.domain.Transaction;





public interface TransactionDAO extends GenericDAO<Transaction, Integer> {
  
	List<Transaction> findAll();
	






}


