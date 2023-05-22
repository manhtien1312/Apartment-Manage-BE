package com.example.apartmentmanagementbe.bill;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@CrossOrigin
@RestController
public class BillController {

	private BillDao billDao = new BillDao();
	
	@GetMapping("/lastest-bills")
	public List<Bill> getLastestBills () throws IOException{
		List<Bill> lastestBills = billDao.selectLastestBills();
		return lastestBills;
	}
	
	@GetMapping("/bill/{id}")
	public Bill getBill(@PathVariable String id) throws IOException{
		Bill bill = billDao.selectBill(Integer.valueOf(id));
		return bill;
	}
	
	@GetMapping("/bill/price-list")
	public ServicePrice getServicePrice() throws IOException{
		ServicePrice sp = billDao.selectServicePrice();
		return sp;
	}
	
	@PostMapping("/bill/payment")
	public void payBill(@RequestBody Payment payment) 
		throws JsonMappingException, JsonProcessingException, SQLException{
		billDao.payBill(payment.getId(), payment.getMoney());
	}
	
	@PostMapping("bill/add/{apartmentid}")
	public void addBill(@RequestBody BillInitiation init, @PathVariable String apartmentid)
		throws JsonMappingException, JsonProcessingException, SQLException{
		billDao.insertBill(init.getElectricNum(), init.getWaterNum(), apartmentid);
	}
	
}
