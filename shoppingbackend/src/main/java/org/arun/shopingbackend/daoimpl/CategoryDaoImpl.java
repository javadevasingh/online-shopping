package org.arun.shopingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.arun.shoppingbackend.dao.CategoryDao;
import org.arun.shoppingbackend.dto.Category;
import org.springframework.stereotype.Repository;

@Repository(value="categoryDAO")
public class CategoryDaoImpl implements CategoryDao{

	private static List<Category> categories = new ArrayList<>();
	
	static{
		//1st Category
		Category category =new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is des for TV");
		category.setImageURL("CAT_1.png");
		categories.add(category);
	
		//second Category
		Category category2 =new Category();

		category2.setId(2);
		category2.setName("mobile");
		category2.setDescription("This is des for Mobile");
		category2.setImageURL("CAT_2.png");
		categories.add(category2);
		
		//Third Category
		Category category3 =new Category();
		category3.setId(3);
		category3.setName("Laptop");
		category3.setDescription("This is des for Laptop");
		category3.setImageURL("CAT_3.png");
		categories.add(category3);
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int categoryid) {
		for(Category category: categories)
		{
			if(category.getId() == categoryid)
				return category;
		}
		return null;
	}

}
