package com.example.apartmentmanagementbe.apartment;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@CrossOrigin
@RestController
public class ApartmentController {

	private ApartmentDao apmDao = new ApartmentDao();
	
	@GetMapping("/apartments")
	public List<Apartment> getAllApartments(Model model) throws IOException{
		List<Apartment> apartments = apmDao.selectAllApartments();
		model.addAttribute("apartments", apartments);
		return apartments;
	}
	
	@GetMapping("/apartment/{apartmentid}")
	public Apartment getApartment(Model model, @PathVariable String apartmentid) {
		model.addAttribute("apartmentid", apartmentid);
		Apartment apartment = apmDao.selectApartment(apartmentid);
		model.addAttribute("apartment", apartment);
		return apartment;
	}
	
	@PutMapping("/apartment/save/{id}")
	public void updateApartment(@RequestBody Apartment apartment, @PathVariable String id) throws JsonMappingException, JsonProcessingException, SQLException{
		apmDao.updateApartment(apartment);
	}
	
}
