package com.cg.fds.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WalletTest {
	
	Wallet w=new Wallet("74.93");
		
	@Test
	void testGetBalance() {
		
		assertEquals("74.93",w.getBalance());
	}

	
}
