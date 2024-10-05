package com.flight.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.entities.Flight;
import com.flight.entities.Passenger;
import com.flight.entities.Reservation;
import com.flight.repository.FlightRepository;
import com.flight.repository.PassengerRepository;
import com.flight.repository.ReservationRepository;
import com.flight.util.EmailUtil;
import com.flight.util.PDFGenerator;
@Controller
public class ReservationController {
	private static String folderPath="C:\\Users\\gotti\\Documents\\workspace-spring-tool-suite-4-4.10.0.RELEASE\\flightReservation\\ticket";
	
	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private PassengerRepository passengerRepo;
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private PDFGenerator pdfGen;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId")long flightId,ModelMap modelMap)
	{
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		modelMap.addAttribute("flight", flight);
		
		return "showCompleteReservation";
	}
	@RequestMapping("/confirmReservation")
	public String confirmReservation(@RequestParam("firstName")String firstName,@RequestParam("lastName")String lastName,
			@RequestParam("middleName")String middleName,@RequestParam("email")String email,@RequestParam("phone")String phone,@RequestParam("flightId")Long flightId,ModelMap modelMap)
	{    
		Passenger passenger=new Passenger();
		passenger.setFirstName(firstName);
		passenger.setLastName(lastName);
		passenger.setMiddleName(middleName);
		passenger.setEmail(email);
		passenger.setPhone(phone);
		
		passengerRepo.save(passenger);
	
		Optional<Flight> findById = flightRepo.findById(flightId);
		Flight flight = findById.get();
		
		Reservation reservation=new Reservation();
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		
		reservation.setPassenger(passenger);
		
		reservation.setFlight(flight);
		 
		
		reservationRepo.save(reservation);
		
		
		modelMap.addAttribute("firstName", firstName);
		modelMap.addAttribute("lastName", lastName);
		modelMap.addAttribute("middleName", middleName);
		modelMap.addAttribute("email" ,email);
		modelMap.addAttribute("phone", phone);

		//then i want the flight details
		modelMap.addAttribute("operatingAirlines",flight.getOperatingAirlines());
		modelMap.addAttribute("departureCity",flight.getDepartureCity());
		modelMap.addAttribute("arrivalCity",flight.getArrivalCity());
		modelMap.addAttribute("estimatedDepartureTime",flight.getEstimatedDepartureTime());
		
		String estimatedDepartureTime = flight.getEstimatedDepartureTime().toString();
		
	pdfGen. generatePDF(folderPath+"ticket"+passenger.getId()+".pdf",passenger.getFirstName(),passenger.getEmail(),passenger.getPhone(),flight.getOperatingAirlines(),estimatedDepartureTime,flight.getDepartureCity(),flight.getArrivalCity());
	
	 emailUtil.sendEmail(passenger.getEmail(),folderPath+"ticket"+passenger.getId()+".pdf");
	
	return "confirmationPage";
	}
	
	

}
