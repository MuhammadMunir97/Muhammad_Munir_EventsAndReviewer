package com.muhammad.events.modells;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(columnDefinition = "VARCHAR(65)")
	@Size(min = 2, message = "Please enter a valid first name of at least 2 characters")
	@NotBlank(message = "Please enter your first name")
    private String firstName;
	
	@Column(columnDefinition = "VARCHAR(65)")
	@Size(min = 2, message = "Please enter a valid last name of at least 2 characters")
	@NotBlank(message = "Please enter your last name")
    private String lastName;
	
	@Column(columnDefinition = "VARCHAR(100)" , unique=true)
	@Email(message = "Please enter a valid email format")
	@NotBlank(message = "Please enter your email")
    private String email;
	
	@Column(columnDefinition = "VARCHAR(100)")
	@Size(min = 2, message = "Please enter a valid location of at least 2 characters")
	@NotBlank(message = "Please enter your location")
    private String location;
	
	@Column(columnDefinition = "VARCHAR(2)")
	@Size(min = 2, message = "Please enter a valid location of at least 2 characters")
	@NotBlank(message = "Please enter your state")
    private String state;
	
	@Column(columnDefinition = "VARCHAR(65)")
	@Size(message = "Password must be between 8 and 16 characters")
	@NotBlank(message = "Please enter a valid password")
    private String password;

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "attending_user_events", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "event_id")
    )   
	private List<Event> attendingEvents;
	
	@OneToMany(mappedBy="admin", fetch = FetchType.LAZY)
	private List<Event> createdEvents;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Comment> comments;
	
	public List<Event> getAttendingEvents() {
		return attendingEvents;
	}

	public void setAttendingEvents(List<Event> attendingEvents) {
		this.attendingEvents = attendingEvents;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Event> getCreatedEvents() {
		return createdEvents;
	}

	public void setCreatedEvents(List<Event> createdEvents) {
		this.createdEvents = createdEvents;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
