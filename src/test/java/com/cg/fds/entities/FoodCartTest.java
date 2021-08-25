package com.cg.fds.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class FoodCartTest {
	List<Item>itemList = new ArrayList<>();
	
	
	

	@Test
	void testGetCartId() {
		
		itemList.add(new Item(58, "Biriyani", "11", 2, 260,""));
		FoodCart ft=new FoodCart(5467,new Customer(1511, "saurabh", "Thangaraj", "male", "8454057599",
	    		new Address("Kumutha Flat","Chennai", "TamilNadu", "India", "600014"), "muttal19@gmail.com",
	    		new Wallet("840")),itemList);
		
		assertEquals(5467,ft.getCartId());
	}
	

}
