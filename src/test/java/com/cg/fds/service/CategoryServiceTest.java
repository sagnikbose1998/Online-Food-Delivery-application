package com.cg.fds.service;



import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.fds.entities.Category;
import com.cg.fds.repository.ICategoryRepository;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class CategoryServiceTest {
	
	@Autowired
	CategoryService categoryservice;
	
	@Autowired
	ICategoryRepository categoryrepository;
	Category c = new Category();
	
			
	
	@Test
	public void CategoryDetailTest() {
		Category category = new Category(85, "Chinese");
		assertEquals(85, category.getCatId());
		assertEquals("Chinese", category.getCategoryName());
		
	}
	
	
	
	@Test
	public final void testToStringCategory() {
		Category category = new Category(85, "Chinese");
		String result = String.format("Category [catId=%s, categoryName=%s]",
				category.getCatId(),category.getCategoryName());
		
		assertEquals(result, category.toString());
	}
	
}
	
	

















