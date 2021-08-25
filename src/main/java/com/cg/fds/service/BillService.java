package com.cg.fds.service;

/************************************************************************************
 *          @author          Indranil
 *          Description      It is a Bill service implementation class that defines the method
 *         Version             1.0
 *         Created Date     29-JULY-2021
 ************************************************************************************/


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fds.entities.Bill;
import com.cg.fds.exception.NoBillWithGivenIdException;
import com.cg.fds.repository.IBillRepository;

@Service
public class BillService {

	@Autowired
	private IBillRepository billRepository;

	public Bill generateBill(Bill bill) {
		return billRepository.save(bill);
	}


	public Bill getBillById(String id) {
		return billRepository.findById(id)
				.orElseThrow(() -> new NoBillWithGivenIdException("No Bill with Given Id Found!"));
		
	}

	public List<Bill> getBillByCustomerId(String custId){
		return billRepository.findByCustomerId(custId);
	}

	public Bill updateBill(String billId,Bill bill) {
		billRepository.deleteById(billId);
		return billRepository.save(bill);
	}

	public void deleteBill(String billId) throws NoBillWithGivenIdException {
		billRepository.findById(billId)
			.orElseThrow(() -> new NoBillWithGivenIdException("No Bill with Given Id Found!"));
		billRepository.deleteById(billId);

	}
}
