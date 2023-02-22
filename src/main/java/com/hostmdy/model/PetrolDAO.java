package com.hostmdy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class PetrolDAO {
	
	private DataSource dataSource;
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	
	public PetrolDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	private void close() {
		// TODO Auto-generated method stub
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int createPetrol(Petrol petrol) {
		int rowUpdated = 0;
		try {
			connection = dataSource.getConnection();
			
			pStmt = connection.prepareStatement("INSERT INTO `petrol_unit_price` "
					+ "(`petrol_type`, `quantity`, `unit_price`, `instock`) " 
					+ "VALUES (?,?,?,?);");
			pStmt.setString(1, petrol.getPetrol_type());
			pStmt.setDouble(2, petrol.getQuantity());
			pStmt.setDouble(3, petrol.getUnit_price());
			pStmt.setBoolean(4, petrol.getInstock());
			rowUpdated = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return rowUpdated;
	}
	
	public List<Petrol> getAllPetrol() {
		List<Petrol> petrolList = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			
			stmt = connection.createStatement();
			
			rs = stmt.executeQuery("Select * from petrol_unit_price;");
			
			while (rs.next()) {
				petrolList.add(new Petrol(rs.getInt("id"), 
						rs.getString("petrol_type"), 
						rs.getDouble("quantity"), 
						rs.getDouble("unit_price"), 
						rs.getBoolean("instock")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return petrolList;
	}
	
	public Petrol getPetrolListById(Integer id) {
		Petrol petrol = null;
		try {
			connection = dataSource.getConnection();
			
			stmt = connection.createStatement();
			
			rs = stmt.executeQuery("Select * from petrol_unit_price where id ='"+id+"';");
			
			while (rs.next()) {
				petrol = new Petrol(rs.getInt("id"),
						rs.getString("petrol_type"),
						rs.getDouble("quantity"),
						rs.getDouble("unit_price"),
						rs.getBoolean("instock"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return petrol;
	}
	
	public int updatePetrol(Petrol petrol) {
		int rowUpdated = 0;
		try {
			connection = dataSource.getConnection();
			
			pStmt = connection.prepareStatement("UPDATE `petrol_unit_price` "
					+ "SET `petrol_type` = ?," + "`quantity` = ?," + 
					"`unit_price` = ?," + "`instock` = ? WHERE (`id` = ?);");
			pStmt.setString(1, petrol.getPetrol_type());
			pStmt.setDouble(2, petrol.getQuantity());
			pStmt.setDouble(3, petrol.getUnit_price());
			pStmt.setBoolean(4, petrol.getInstock());
			pStmt.setInt(5, petrol.getId());
			rowUpdated = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return rowUpdated;
	}
	
	public int deletePetrol(Integer id) {
		int rowUpdated = 0;
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("Delete from petrol_unit_price where id =?;");
			pStmt.setInt(1, id);
			rowUpdated = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return rowUpdated;
	}

	public Petrol getPetrolByName(String petrol_type) {
		Petrol petrol = null;
		try {
			connection = dataSource.getConnection();
			
			stmt = connection.createStatement();
			
			rs = stmt.executeQuery("Select * from petrol_unit_price where id ='"+petrol_type+"';");
			
			while (rs.next()) {
				petrol = new Petrol(rs.getInt("id"),
						rs.getString("petrol_type"),
						rs.getDouble("quantity"),
						rs.getDouble("unit_price"),
						rs.getBoolean("instock"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return petrol;
	}

}
