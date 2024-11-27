package com.skylot222.dao;

import java.util.List;

import com.skylot222.dao.GenericDAO;
import com.skylot222.domain.Watchlist;





public interface WatchlistDAO extends GenericDAO<Watchlist, Integer> {
  
	List<Watchlist> findAll();
	






}


