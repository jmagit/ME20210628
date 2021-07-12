package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ioc.Servicio;

@SpringBootApplication
public class MvcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MvcApplication.class, args);
	}

	@Autowired
	Servicio srv;
	
	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Ya estamos");
		
		srv.remove(0);
	}

}
