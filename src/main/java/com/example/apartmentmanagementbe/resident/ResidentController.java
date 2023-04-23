package com.example.apartmentmanagementbe.resident;

import java.io.IOException;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ResidentController {

	private ResidentDao residentDao = new ResidentDao();
	
	@GetMapping("/residents")
	public List<Resident> getAllApartments(Model model) throws IOException{
		List<Resident> residents = residentDao.selectAllResidents();
		model.addAttribute("residents", residents);
		return residents;
	}
	
	@GetMapping("/resident/{residentid}")
	public Resident getResident(Model model, @PathVariable String residentid) {
		model.addAttribute("residentid", residentid);
		Resident resident = residentDao.selectResident(Integer.valueOf(residentid));
		model.addAttribute("resident", resident);
		return resident;
	}
	
}
