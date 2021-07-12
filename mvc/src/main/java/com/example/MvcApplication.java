package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	
	@Autowired(required = false)
	Servicio srv;
	@Autowired(required = false)
	Servicio srv2;
	
	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Ya estamos");
		
		if(srv != null)
		srv.remove(0);
		srv.modify(null);
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
