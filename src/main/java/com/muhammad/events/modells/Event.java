package com.muhammad.events.modells;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(columnDefinition = "VARCHAR(65)")
	@Size(min = 2, message = "Please enter a valid name of at least 2 characters")
	@NotBlank(message = "Please enter your name")
    private String name;
	
	@Column(columnDefinition = "VARCHAR(100)")
	@Size(min = 2, message = "Please enter a valid location of at least 2 characters")
	@NotBlank(message = "Please enter your location")
    private String location;
	
	@Column(columnDefinition = "VARCHAR(2)")
	@Size(min = 2, message = "Please enter a valid location of at least 2 characters")
	@NotBlank(message = "Please enter your state")
    private String state;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "attending_user_events", 
        joinColumns = @JoinColumn(name = "event_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )   
	private List<User> attendingUsers;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="admin_id")
	private User admin;
	 
	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<User> getAttendingUsers() {
		return attendingUsers;
	}

	public void setAttendingUsers(List<User> attendingUsers) {
		this.attendingUsers = attendingUsers;
	}
	
}
