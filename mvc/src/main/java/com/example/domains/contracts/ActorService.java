package com.example.domains.contracts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.domains.entities.Actor;

public interface ActorService extends DomainService<Actor, Integer> {

	Page<Actor> getAll(Pageable pageable);
}
