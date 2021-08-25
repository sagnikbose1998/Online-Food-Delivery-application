package com.cg.fds.service;

/************************************************************************************
 *          @author          Sagnik
 *          Description      It is a Category service implementation class that defines the method
 *         Version             1.0
 *         Created Date     29-JULY-2021
 ************************************************************************************/


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fds.entities.Category;
import com.cg.fds.entities.Item;
import com.cg.fds.repository.ICategoryRepository;
import com.cg.fds.repository.IItemRepository;

@Service
public class CategoryService {

	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Autowired
	private IItemRepository itemRepository;
	
	public Category addCategory(String catName) {
		int catId=catName.hashCode();
		Category cat=new Category(catId,catName);
		return categoryRepository.save(cat);
	}
	
	public void deleteCategory(int catId) {
		categoryRepository.deleteById(catId);
	}
	
	public Category updateCategory(int catId,String catName) {
		categoryRepository.deleteById(catId);
		Category cat=new Category(catId,catName);
		return categoryRepository.save(cat);
	}
	
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
	
	public Category getCategory(int catId) {
		return categoryRepository.findById(catId).get();
	}
	
	public List<Item> getItemsByCategory(int catId){
		return itemRepository.findByCategoryId(catId);
	}
}
