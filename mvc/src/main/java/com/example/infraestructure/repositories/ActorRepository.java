package com.example.infraestructure.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domains.entities.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
	List<Actor> findByFirstName(String nombre);
	List<Actor> findByLastNameEndingWith(String sufijo);
	List<Actor> findTop10ByActorIdLessThan(int max);
}
