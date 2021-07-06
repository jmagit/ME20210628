package com.example.juegos.naipes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.example.juegos.JuegoException;

public class Baraja {
	private Naipe[] cartas;
	private Deque<Naipe> mazo;

	public Baraja() {
		cartas = new Naipe[40];
		int delta = 0;
		for (Naipe.Palos palo : Naipe.Palos.values()) {
			for (byte i = 0; i < 10; i++)
				try {
					cartas[10 * delta + i] = new Naipe(palo, (byte)(i + 1));
				} catch (JuegoException e) {
				}
			delta++;
		}
	}
	
	public Naipe[] getCartas() {
		return cartas.clone();
	}
	
	public void barajar() {
		class Orden {
			public Naipe carta;
			public int posicion;
			public Orden(Naipe carta, int posicion) {
				super();
				this.carta = carta;
				this.posicion = posicion;
			}			
		}
		Random rnd = new Random();
		mazo = new ArrayDeque<Naipe>(Arrays.asList(cartas).stream()
			.map(item -> new Orden(item, rnd.nextInt(1000)))
			.sorted((a, b) -> a.posicion - b.posicion)
			.map(item -> item.carta)
			.collect(Collectors.toList()));
	}
	
	public List<Naipe> getMazo() {
		return mazo.stream().collect(Collectors.toList());
	}
	
	public List<List<Naipe>> reparte(int jugadores, int cartas) {
		List<List<Naipe>> mano = new ArrayList<List<Naipe>>();
		for(int i=0; i < jugadores; i++) {
			mano.add(new ArrayList<Naipe>());			
		}
		for(int i=0; i < cartas; i ++)
			for(int j=0; j < jugadores; j++) {
				if(mano.size() == 0)
					return mano;
				mano.get(j).add(mazo.poll());
			}
		return mano;
	}
}
