package com.cg.fds.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cg.fds.controller.CustomerController;
import com.cg.fds.entities.Address;
import com.cg.fds.entities.Customer;
import com.cg.fds.entities.Wallet;
import com.cg.fds.service.CustomerService;


@WebMvcTest(controllers = CustomerController.class)
@ActiveProfiles("test")
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;

	private List<Customer> custList;

	@BeforeEach
	void setUp() {
		this.custList = new ArrayList<>();
		this.custList.add(new Customer(1511, "saurabh", "Thangaraj", "male", "8454057599",
				new Address("Kumutha Flat","Chennai", "TamilNadu", "India", "600014"),
				"muttal19@gmail.com", new Wallet("840")));
		this.custList.add(new Customer(1512, "proalbh", "suntharam", "male", "8454057899",
				new Address("kanjana Flat", "Chennai", "TamilNadu", "India", "600014"),
				"muttal19@gmail.com", new Wallet("1240")));

	}

	@Test
	void shouldFetchAllCustomer() throws Exception {
		given(customerService.getAllCustomer()).willReturn(this.custList);

		this.mockMvc.perform(get("/fdsdata/customer/show")).andExpect(status().isOk())
				.andExpect(jsonPath("$.size()", is(custList.size())));
	}

	@Test
	void fetchCustomerById() throws Exception {
		int custId = 1412;
		Customer cust = new Customer(custId, "saurabh", "Thangaraj", "male", "8454057599",
				new Address("Kumutha Flat","Chennai", "TamilNadu", "India", "600014"),
				"muttal19@gmail.com", new Wallet("840"));
		given(customerService.showCustomer(custId)).willReturn(cust);

		
		this.mockMvc.perform(get("/fdsdata/customer/show/{cid}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName",is(cust.getFirstName()) ))
				.andExpect(jsonPath("$.lastName", is(cust.getLastName())))
				.andExpect(jsonPath("$.gender", is(cust.getGender())))
				.andExpect(jsonPath("$.mobileNumber", is(cust.getMobileNumber())))
				.andExpect(jsonPath("$.address", is(cust.getAddress())))
				.andExpect(jsonPath("$.email", is(cust.getEmail())))
				.andExpect(jsonPath("$.wallet", is(cust.getWallet())))
				;

	}

}
