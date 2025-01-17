package com.flight.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.entities.Flight;
import com.flight.repository.FlightRepository;

@Controller
public class FlightController {
	@Autowired
	private FlightRepository flightRepo;
	
	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("from")String from,@RequestParam("to")String to,@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,ModelMap modelMap)
	{
		List<Flight> findFlight = flightRepo.findFlight(from,to,departureDate);
	
		modelMap.addAttribute("flights", findFlight);
		return "dispalyFlights";
	}
	

}
