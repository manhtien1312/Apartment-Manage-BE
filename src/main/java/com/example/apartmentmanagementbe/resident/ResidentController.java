package com.example.apartmentmanagementbe.resident;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

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
	
	@PutMapping("/resident/save/{residentid}")
	public void updateResident(@RequestBody Resident resident, @PathVariable String residentid)
		throws JsonMappingException, JsonProcessingException, SQLException{
		residentDao.updateResident(resident);
	}
	
	@PostMapping("/resident/add/{residentid}")
	public void addResident(@RequestBody Resident resident, @PathVariable String residentid)
		throws JsonMappingException, JsonProcessingException, SQLException{
		residentDao.insertResident(resident);
	}
	
	@GetMapping("/resident/delete/{residentid}")
	public void deleteResident(@PathVariable String residentid) {
		residentDao.deleteResident(Integer.valueOf(residentid));
	}
	
}
