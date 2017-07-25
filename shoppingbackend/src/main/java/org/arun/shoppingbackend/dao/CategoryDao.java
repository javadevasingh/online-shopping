package org.arun.shoppingbackend.dao;

import java.util.List;

import org.arun.shoppingbackend.dto.Category;


public interface CategoryDao {

	List <Category> list();
	Category get(int id);
	
}
