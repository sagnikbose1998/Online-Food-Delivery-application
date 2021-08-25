package com.cg.fds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fds.entities.Item;

@Repository
public interface IItemRepository extends JpaRepository<Item,Integer>{
	
	public List<Item> findByItemName(String name);
	public List<Item> findByCategoryId(int categoryId);
	
}
