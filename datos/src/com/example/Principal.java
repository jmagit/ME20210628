package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) {
		consulta1();

	}

	private static void consulta1() {
		try(Connection connection = JDBCBridged.getConnection()) {
			Statement cmd = connection.createStatement();
			ResultSet rs = cmd.executeQuery("SELECT film_id, title FROM film");
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

}
