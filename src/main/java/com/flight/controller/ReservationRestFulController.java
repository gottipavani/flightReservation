package com.flight.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.flight.entities.Reservation;
import com.flight.repository.ReservationRepository;

@RestController
public class ReservationRestFulController {
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@GetMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id")Long id)
	{
		Optional<Reservation> findById = reservationRepo.findById(id);
		Reservation reservation = findById.get();
		return reservation;
	}

}
