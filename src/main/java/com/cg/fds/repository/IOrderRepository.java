package com.cg.fds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fds.entities.OrderDetails;

@Repository
public interface IOrderRepository extends JpaRepository<OrderDetails,Integer>{
	public List<OrderDetails> findByCustomerId(String custId);
}
