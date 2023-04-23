package com.example.apartmentmanagementbe.apartment;

import java.io.IOException;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
	
}
