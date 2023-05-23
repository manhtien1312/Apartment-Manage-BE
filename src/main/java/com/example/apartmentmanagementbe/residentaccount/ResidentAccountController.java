package com.example.apartmentmanagementbe.residentaccount;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@CrossOrigin
@RestController
public class ResidentAccountController {

	public ResidentAccountDAO dao = new ResidentAccountDAO();
	
	@PostMapping("/resident-account")
	public ResidentAccount loginRequest(@RequestBody ResidentAccount acc)
		throws JsonMappingException, JsonProcessingException, SQLException{
		ResidentAccount accResponse = dao.getAccount(acc.getUsername(), acc.getPassword());
		return accResponse;
	}
	
	@PostMapping("/resident-account/change-password")
	public void changePassword (@RequestBody ResidentAccount acc)
		throws JsonMappingException, JsonProcessingException, SQLException{
		dao.updateAccount(acc.getPassword(), acc.getId());
	}
}