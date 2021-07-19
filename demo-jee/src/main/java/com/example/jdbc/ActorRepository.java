package com.example.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ActorRepository {
	public List<Actor> getAll() {
		List<Actor> rslt = new ArrayList<>();
		try (Connection con = JDBCBridged.getConnection()) {
			Statement cmd = con.createStatement();
			ResultSet rs = cmd.executeQuery(
					"SELECT actor_id,first_name,last_name,last_update FROM actor ORDER BY first_name, last_name");
			while (rs.next()) {
				rslt.add(new Actor(rs.getShort("actor_id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getDate("last_update")));
			}
			rs.close();
			cmd.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rslt;
	}

	public Optional<Actor> getOne(Short id) {
		try (Connection con = JDBCBridged.getConnection()) {
			PreparedStatement cmd = con
					.prepareStatement("SELECT actor_id,first_name,last_name,last_update FROM actor WHERE actor_id=?");
			cmd.setShort(1, id);
			ResultSet rs = cmd.executeQuery();
			if (rs.next())
				return Optional.of(new Actor(rs.getShort("actor_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getDate("last_update")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
	public Actor add(Actor item) throws InvalidDataException, SQLException {
		if(item == null || item.isNotValid())
			throw new InvalidDataException();
		try (Connection con = JDBCBridged.getConnection()) {
			PreparedStatement cmd = con
					.prepareStatement("INSERT INTO Actor(first_name, last_name) VALUES(?,?)", new String[] {"actor_id"});
			cmd.setString(1, item.getFirstName());
			cmd.setString(2, item.getLastName());
			cmd.executeUpdate();
			ResultSet rs = cmd.getGeneratedKeys();
			rs.next();
			return getOne(rs.getShort(1)).get();
		} catch (SQLException e) {
			throw e;
		}
	}
	public Actor modify(Actor item) throws SQLException, NotFoundException, InvalidDataException {
		if(item == null || item.isNotValid() || item.getActorId() == null)
			throw new InvalidDataException();
		try (Connection con = JDBCBridged.getConnection()) {
			PreparedStatement cmd = con
					.prepareStatement("UPDATE Actor SET first_name = ?, last_name = ? WHERE actor_id= ?", new String[] {"last_update"});
			cmd.setString(1, item.getFirstName());
			cmd.setString(2, item.getLastName());
			cmd.setShort(3, item.getActorId());
			if(cmd.executeUpdate() == 0)
				throw new NotFoundException();
//			ResultSet rs = cmd.getGeneratedKeys();
//			rs.next();
//			item.setLastUpdate(rs.getDate(1));
		} catch (SQLException e) {
			throw e;
		}
		return item;
	}
	public void delete(short id) throws NotFoundException, SQLException {
		try (Connection con = JDBCBridged.getConnection()) {
			PreparedStatement cmd = con
					.prepareStatement("DELETE FROM actor WHERE actor_id=?");
			cmd.setShort(1, id);
			if(cmd.executeUpdate() == 0)
				throw new NotFoundException();
		} catch (SQLException e) {
			throw e;
		}
	}
	public void delete(Actor item) throws NotFoundException, SQLException {
		if(item == null || item.getActorId() == null)
			throw new NotFoundException();
		delete(item.getActorId());
	}

}
