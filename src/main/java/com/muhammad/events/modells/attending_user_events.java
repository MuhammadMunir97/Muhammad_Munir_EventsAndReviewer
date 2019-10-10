package com.muhammad.events.modells;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="attending_user_events")
public class attending_user_events {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
	private User userAttending;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="event_id")
	private Event eventAttended;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUserAttending() {
		return userAttending;
	}

	public void setUserAttending(User userAttending) {
		this.userAttending = userAttending;
	}

	public Event getEventAttended() {
		return eventAttended;
	}

	public void setEventAttended(Event eventAttended) {
		this.eventAttended = eventAttended;
	}
	
	
	
}
