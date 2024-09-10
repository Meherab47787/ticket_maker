package com.test.java_test.repository;

import com.test.java_test.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer> {
    Optional<Airport> findByAirportId(Integer airportId);
}
