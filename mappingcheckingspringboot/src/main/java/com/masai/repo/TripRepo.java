package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Trip;

public interface TripRepo extends JpaRepository<Trip, Integer> {

}
