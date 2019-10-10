package com.muhammad.events.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.muhammad.events.modells.Event;
import com.muhammad.events.repositories.EventRepository;

@Service
public class EventService {
	
	private final EventRepository eventRepo;

	public EventService(EventRepository eventRepo) {
		this.eventRepo = eventRepo;
	}
	
	
	public List<Event> findAllEvents(){
		return eventRepo.findAll();
	}
	
	public Event saveEvent(Event event) {
		return eventRepo.save(event);
	}
	
	public void deleteEventById(Long id) {
		eventRepo.deleteById(id);
	}
}
