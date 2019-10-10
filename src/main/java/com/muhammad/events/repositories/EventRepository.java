package com.muhammad.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.muhammad.events.modells.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{

}
