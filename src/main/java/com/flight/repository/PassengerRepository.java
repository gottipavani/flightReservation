package com.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
