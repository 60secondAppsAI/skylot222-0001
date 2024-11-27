package com.skylot222.dao;

import java.util.List;

import com.skylot222.dao.GenericDAO;
import com.skylot222.domain.Wishlist;





public interface WishlistDAO extends GenericDAO<Wishlist, Integer> {
  
	List<Wishlist> findAll();
	






}


