package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Principal {

	public static void main(String[] args) {
//		consulta3(2);
//		add("uno");
//		modify(11, "OTRO");
		remove(10);
	}
	
	static class Peli {
		private int id;
		private String titulo;
		public Peli(int id, String titulo) {
			super();
			this.id = id;
			this.titulo = titulo;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		@Override
		public String toString() {
			return "Peli [id=" + id + ", titulo=" + titulo + "]";
		}
		
		
	}
	
	private static void consulta3(int id) {
		List<Peli> lst = new ArrayList<>();
		
		try(Connection connection = JDBCBridged.getConnection()) {
			PreparedStatement cmd = connection.prepareStatement("SELECT film_id, title FROM film WHERE film_id = ?");
			cmd.setInt(1, id);
			ResultSet rs = cmd.executeQuery();
			while(rs.next()) {
				lst.add(new Peli(rs.getInt(1), rs.getString("title")));
			}
			rs.close();
			cmd.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		lst.forEach(System.out::println);
	}
	
	private static void consulta2(int id) {
		List<Peli> lst = new ArrayList<>();
		
		try(Connection connection = JDBCBridged.getConnection()) {
			Statement cmd = connection.createStatement();
			ResultSet rs = cmd.executeQuery("SELECT film_id, title FROM film WHERE film_id = " + id);
			while(rs.next()) {
				lst.add(new Peli(rs.getInt(1), rs.getString("title")));
			}
			rs.close();
			cmd.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		lst.forEach(System.out::println);
	}

	private static void consulta1() {
		try(Connection connection = JDBCBridged.getConnection()) {
			Statement cmd = connection.createStatement();
			ResultSet rs = cmd.executeQuery("SELECT film_id, title FROM film WHERE rating = 'PG'");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString("title"));
			}
			rs.close();
			cmd.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		try {
//			Connection connection = JDBCBridged.getConnection();
//			try {
//				// ...
//			} finally {
//				connection.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}

	private static void add(String nombre) {
		try(Connection connection = JDBCBridged.getConnection()) {
			PreparedStatement cmd = connection.prepareStatement(
					"INSERT INTO " +
					" language(NAME) VALUES(?)");
			cmd.setString(1, nombre);
			var rslt = cmd.executeUpdate();
			if(rslt == 0) {
				System.out.println("Problemas al insertar.");
			} else {
				System.out.println("Insertado correctamente");
			}
			cmd.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void modify(int id, String nombre) {
		try(Connection connection = JDBCBridged.getConnection()) {
			PreparedStatement cmd = connection.prepareStatement(
					"UPDATE language SET NAME = ? WHERE language_id = ?");
			cmd.setString(1, nombre);
			cmd.setInt(2, id);
			var rslt = cmd.executeUpdate();
			if(rslt == 0) {
				System.out.println("No se ha modificado ninguno.");
			} else {
				System.out.println("Modificado correctamente");
			}
			cmd.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void remove(int id) {
		try(Connection connection = JDBCBridged.getConnection()) {
			PreparedStatement cmd = connection.prepareStatement(
					"DELETE FROM language WHERE language_id = ?");
			cmd.setInt(1, id);
			var rslt = cmd.executeUpdate();
			if(rslt == 0) {
				System.out.println("No se ha borrado ninguno.");
			} else {
				System.out.println("Borrado correctamente");
			}
			cmd.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
