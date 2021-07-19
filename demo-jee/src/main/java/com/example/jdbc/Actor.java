package com.example.jdbc;

import java.util.Date;
import javax.annotation.Generated;

public class Actor {
    private Short actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate;
    
	public Actor() {
	}
	public Actor(Short actorId) {
		this.actorId = actorId;
	}
	public Actor(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Actor(Short actorId, String firstName, String lastName, Date lastUpdate) {
		this.actorId = actorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastUpdate = lastUpdate;
	}
	public Short getActorId() {
		return actorId;
	}

	public void setActorId(Short actorId) {
		this.actorId = actorId;
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

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", firstName=" + firstName + ", lastName=" + lastName + ", lastUpdate="
				+ lastUpdate + "]";
	}
	public boolean isNotValid() {
		return firstName == null || firstName.length() > 45 ||
				lastName == null || lastName.length() > 45;
	}

}