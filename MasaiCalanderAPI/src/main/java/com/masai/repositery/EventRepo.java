package com.masai.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.models.Event;

public interface EventRepo extends JpaRepository<Event, Integer> {

}
