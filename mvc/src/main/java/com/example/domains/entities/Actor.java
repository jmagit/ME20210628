package com.example.domains.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.example.domains.core.Entidad;
import com.example.domains.core.NIF;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the actor database table.
 * 
 */
@Entity
@NamedQuery(name="Actor.findAll", query="SELECT a FROM Actor a")
public class Actor extends Entidad<Actor> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="actor_id")
	private int actorId;

	@Column(name="first_name")
	@NotBlank
	@Length(max = 45, min=2)
	private String firstName;

	@Column(name="last_name")
	@NotBlank
	@Length(max = 45)
	private String lastName;

	@Column(name="last_update", insertable=false, updatable=false)
	private Timestamp lastUpdate;

	//bi-directional many-to-one association to FilmActor
	@OneToMany(mappedBy="actor", cascade = CascadeType.ALL /*, fetch = FetchType.EAGER*/)
	@Valid
	@JsonIgnore
	private List<FilmActor> filmActors;

	public Actor() {
		filmActors = new ArrayList<>();
	}

	public Actor(int actorId) {
		this.actorId = actorId;
	}

	public Actor(int actorId, String firstName, String lastName) {
		super();
		this.actorId = actorId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getActorId() {
		return this.actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<FilmActor> getFilmActors() {
		return this.filmActors;
	}

	public void setFilmActors(List<FilmActor> filmActors) {
		this.filmActors = filmActors;
	}

	public FilmActor addFilmActor(FilmActor filmActor) {
		getFilmActors().add(filmActor);
		filmActor.setActor(this);

		return filmActor;
	}

	public FilmActor removeFilmActor(FilmActor filmActor) {
		getFilmActors().remove(filmActor);
		filmActor.setActor(null);

		return filmActor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actorId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return actorId == other.actorId;
	}

	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", name=" + firstName + " " + lastName + "]";
	}
	
	
}