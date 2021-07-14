package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.domains.contracts.ActorService;
import com.example.domains.entities.Actor;
import com.example.domains.entities.FilmActor;
import com.example.infraestructure.repositories.ActorRepository;
import com.example.infraestructure.repositories.PeliculasRepository;
import com.example.ioc.Repositorio;
import com.example.ioc.RepositorioImpl;
import com.example.ioc.RepositorioMockImpl;
import com.example.ioc.Servicio;
import com.example.ioc.ServicioImpl;

@SpringBootApplication
public class MvcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MvcApplication.class, args);
	}

	@Value("${modo}") 
	private String modo;
	
//	@Autowired(required = false)
//	Servicio srv;
//	@Autowired(required = false)
//	Servicio srv2;
	
	@Autowired
	ActorRepository dao;

	@Autowired
	PeliculasRepository daoPelis;
	
	@Autowired
	ActorService srvActor;
	
	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	@Transactional
	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Ya estamos");
		
//		if(srv != null)
//		srv.remove(0);
//		srv.modify(null);
//		dao.save(new Actor(0, "Pepito", "Grillo"));
//		var peli =  daoPelis.getById(1);
//		System.out.println(peli);
//		var actor = dao.findById(201).get();
//		actor.setFirstName(actor.getFirstName().toUpperCase());
//		actor.setLastName(actor.getLastName().toLowerCase());
//		actor.setFilmActors(new ArrayList<>());
//		actor.addFilmActor(new FilmActor(actor, peli));
//		actor.addFilmActor(new FilmActor(actor, daoPelis.getById(5)));
//		actor.addFilmActor(new FilmActor(actor, daoPelis.getById(3)));
//		dao.save(actor);
		//dao.findAll().forEach(System.out::println);
//		var actor = dao.findById(1);
//		System.out.println(actor.get());
//		var otro = dao.findById(201).get();
//		otro.getFilmActors().forEach(item -> System.out.println(item.getFilm()));
//		dao.deleteById(201);
//		dao.findByFirstName("Penelope").forEach(System.out::println);
//		dao.findByLastNameEndingWith("pe").forEach(System.out::println);
//		dao.findTop10ByActorIdLessThan(15).forEach(System.out::println);
		
//		Actor actor = new Actor(201, "Pepito", "Grillo");
//		srvActor.modify(actor);
//		srvActor.remove(new Actor(202));
//		srvActor.getAll().forEach(System.out::println);
//		if(actor.isValid()) {
//			System.out.println("Es valido");
//		} else {
//			System.out.println(actor.getErrorsMessage());
//		}
//		dao.save(actor);
		System.out.println(jdbcTemplate.queryForObject("select count(*) from actor", Integer.class));
		List<Actor> actors = this.jdbcTemplate.query(
		        "select actor_id, first_name, last_name from actor",
		        (rs, ind) -> new Actor(rs.getInt(1), rs.getString(2), rs.getString(3)));
		actors.forEach(System.out::println);
	}

	@Bean
	public Repositorio getRepositorio(@Value("${modo}") String modo) {
		System.out.println(modo);
		if("test".equals(modo)) {
			return new RepositorioMockImpl();
		} else {
			return new RepositorioImpl();
		}
	}
}
